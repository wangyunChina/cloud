package com.muc.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@FeignClient(value = "epie", fallback = EpieServiceImp.class)
public interface EpieService {

    @RequestMapping(value = "/epie/login_by_weixin", method = RequestMethod.GET)
    public Map login_by_weixin(@RequestParam("code") String code, @RequestParam("encryptedData")String encryptedData,@RequestParam("iv") String iv, @RequestParam("request")HttpServletRequest request);

}