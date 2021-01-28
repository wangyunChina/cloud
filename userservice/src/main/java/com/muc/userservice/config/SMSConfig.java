package com.muc.userservice.config;

import com.alibaba.fastjson.JSON;
import com.muc.userservice.model.SMSCodeMap;
import com.muc.userservice.model.SMSTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SMSConfig {
    @Value("${aliyun.SMS.template.id}")
    private String templateId;
    @Value("${aliyun.SMS.template.id.param}")
    private String templateParam;
    @Bean
    public SMSTemplate MySMSTemplate(){
        return SMSTemplate.builder()
                .templateId(templateId)
                .templateParam(templateParam)
                .build();
    }
    @Bean
    public SMSCodeMap codeMap(){
        return new SMSCodeMap();
    }
}
