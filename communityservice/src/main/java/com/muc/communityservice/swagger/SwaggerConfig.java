package com.muc.communityservice.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    @Value("${swagger.host}")
    private String swaggerHost;

    @Bean
    public Docket createRestApi() {

//        ParameterBuilder ticketPar = new ParameterBuilder();
        ParameterBuilder ticketPar2 = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
//        ticketPar.name("Authorization").description("登录校验")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).defaultValue("Bearer ").build();
        ticketPar2.name("apiToken").description("登录校验")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).defaultValue("apiToken").build();

//        pars.add(ticketPar.build());
        pars.add(ticketPar2.build());

        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        if(StringUtils.isNotBlank(swaggerHost)){
            docket=docket.host(swaggerHost);
            //docket.pathMapping(swaggerHost);
        }
        docket = docket.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.muc.fileservice.controller")) // 配置需要扫描的包路径   .globalOperationParameters(pars)
                .paths(PathSelectors.any()).build().globalOperationParameters(pars);


        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("测试")
                .description("提供统一的外部与移动端接口服务").version("0.0.1").build();
    }

}
