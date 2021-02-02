package com.muc.userservice.controller;

import com.aliyuncs.exceptions.ClientException;
import com.muc.userservice.model.ReqSMSSendVo;
import com.muc.userservice.model.Result;
import com.muc.userservice.model.ResultGenerator;
import com.muc.userservice.service.SmsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/api")
@Api(value = "用户管理")
@Slf4j
public class SMSController extends BaseController {
    @Autowired
    SmsService smsService;
    @PostMapping(value = "/open/v1/SMS/send",name = "发送短信")
    public Result send(@RequestBody ReqSMSSendVo reqSMSSendVo) throws ClientException {
        try {
            return  smsService.sendSms(reqSMSSendVo);
        }catch(ClientException e){
            log.error(e.getMessage());
        }
        return ResultGenerator.genFailResult("短信发送失败");
    }
    @PostMapping(value = "/open/v1/SMS/check",name = "校验验证码")
    public Result check(@RequestBody ReqSMSSendVo reqSMSSendVo) throws ClientException {
        try {
          return  smsService.sendSms(reqSMSSendVo);
        }catch(ClientException e){
            log.error(e.getMessage());
        }
        return ResultGenerator.genSuccessResult();
    }
}
