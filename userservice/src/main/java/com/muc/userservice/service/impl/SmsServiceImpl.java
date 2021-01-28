package com.muc.userservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.muc.userservice.consts.Consts;
import com.muc.userservice.model.*;
import com.muc.userservice.service.SmsService;
import com.muc.userservice.util.SecureRandomUtil;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Value("${aliyun.AccessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.AccessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.SMS.API.URL}")
    private String smsAPIURL;
    @Autowired
    private SMSTemplate sMSTemplate;
    @Autowired
    private SMSCodeMap sMSCodeMap;
    @Override
    public void sendSms(ReqSMSSendVo smsSendVo) throws ClientException {
        SMSCodeVo sessionCode = sMSCodeMap.get(smsSendVo.getMobile());
        if(sessionCode!=null&& LocalDateTime.now().compareTo(sessionCode.getExpireTime())<0){
            log.error("用户：{} 已经发送过验证码，请不要重复点击！",smsSendVo.getMobile());
            return;
        }
//初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
//初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, smsAPIURL);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
        request.setPhoneNumbers(smsSendVo.getMobile());
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(Consts.signName);
        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        request.setTemplateCode(sMSTemplate.getTemplateId());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
//参考：request.setTemplateParam("{\"变量1\":\"值1\",\"变量2\":\"值2\",\"变量3\":\"值3\"}")
        SMSTemplateParam param= JSONObject.parseObject(sMSTemplate.getTemplateParam(),SMSTemplateParam.class);
        param.setCode(getCode());
        request.setTemplateParam(JSONObject.toJSONString(param));
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId(UUID.randomUUID().toString());

//请求失败这里会抛ClientException异常
        try {
            log.info("手机号:{} 验证码：{}",smsSendVo.getMobile(),param.getCode());
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            log.info("手机号:{} 验证码：{} 发送成功！",smsSendVo.getMobile(),param.getCode());
//请求成功,将数据缓存起来等待用户登录消费
            sMSCodeMap.put(smsSendVo.getMobile(), SMSCodeVo.builder().code(param.getCode()).expireTime(LocalDateTime.now().plusMinutes(3)).build());
        }else{
           log.error("发送失败：", JSON.toJSONString(sendSmsResponse));
        }
        }catch (ClientException e){

        }
    }
    public String getCode(){
        SecureRandomUtil random = new SecureRandomUtil();
        StringBuilder sb = new StringBuilder();
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
       return sb.toString();
    }
}
