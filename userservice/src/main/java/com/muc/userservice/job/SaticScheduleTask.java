package com.muc.userservice.job;

import com.muc.userservice.model.SMSCodeMap;
import com.muc.userservice.model.SMSCodeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import javax.swing.text.html.HTMLDocument;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class SaticScheduleTask {
    @Autowired
    private SMSCodeMap smsCodeMap;

    @Scheduled(fixedRate=120000)
    public void configureTasks() {
        log.info("开始检测验证码：",LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        Iterator<Map.Entry<String, SMSCodeVo>> entries = smsCodeMap.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String, SMSCodeVo> entry=entries.next();
            if(entry!=null&& LocalDateTime.now().compareTo(entry.getValue().getExpireTime())>=0){
                log.info("用户：{} 验证码：{}过期，已移除",entry.getKey(),entry.getValue().getCode());
                smsCodeMap.remove(entry.getKey());
            }
        }

    }
}
