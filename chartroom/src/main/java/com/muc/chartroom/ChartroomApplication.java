package com.muc.chartroom;

import com.muc.action.WebSocketServer;
import com.netflix.discovery.EurekaNamespace;
import org.apache.catalina.core.ApplicationContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.muc")
@MapperScan("com.muc.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class ChartroomApplication {

    public static void main(String[] args) {
         SpringApplication.run(ChartroomApplication.class, args);


    }


}
