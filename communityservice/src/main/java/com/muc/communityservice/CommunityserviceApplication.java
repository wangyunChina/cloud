package com.muc.communityservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.muc")
@MapperScan(basePackages = "com.muc.fileservice.mapper")
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
public class CommunityserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityserviceApplication.class, args);
    }

}
