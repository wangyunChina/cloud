package com.muc.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CrosConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config=new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedOrigins(Arrays.asList("*"));  //http:www.a.com
        config.setAllowedMethods(Arrays.asList("*"));
        config.setMaxAge(300L);
        source.registerCorsConfiguration("/",config);
        return new CorsFilter(source);
    }
}