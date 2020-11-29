package com.muc.communityservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class BaseController {

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public String getUsid() {
        return getRequest().getHeader("usid");
    }

    public String getApiToken() {
        try {
            String apiToken = getRequest().getHeader("Authorization");


         
          return apiToken;
        } catch (Exception e) {
            log.error("获取apiToken报错："+e);
            return null;
        }
    }

    public String getCopId() {
        return getRequest().getHeader("cid");
    }

    public String getLanguage()
    {
        return getRequest().getHeader("accept-language");
    }
}
