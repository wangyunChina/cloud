package com.muc.clt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@EnableEurekaClient
@ComponentScan(basePackages = "com.muc")
@EnableFeignClients(basePackages = "com.muc")
@MapperScan("com.muc.mapper")
public class CltApplication  {

    public static void main(String[] args) {
        SpringApplication.run(CltApplication.class, args);
    }

}

