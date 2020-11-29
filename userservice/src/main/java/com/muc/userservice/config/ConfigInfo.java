package com.muc.userservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigInfo {
    public static String systemId;
    public static String signSecret;
    public static String dataSecret;
    public static String dataSecretIv;
    @Value("${api.SystemId}")
    public  void setSystemId(String systemId) {
        ConfigInfo.systemId = systemId;
    }
    @Value("${api.sigSecret}")
    public  void setSignSecret(String signSecret) {
        ConfigInfo.signSecret = signSecret;
    }
    @Value("${api.dataSecret}")
    public  void setDataSecret(String dataSecret) {
        ConfigInfo.dataSecret = dataSecret;
    }
    @Value("${api.dataSecretIV}")
    public  void setDataSecretIv(String dataSecretIv) {
        ConfigInfo.dataSecretIv = dataSecretIv;
    }

}
