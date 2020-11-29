package com.muc.action;

import com.muc.service.EpieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class EpieAction {
    @Resource
    EpieService epieService;
    @RequestMapping("/login_by_weixin")
    public Map loginByWeixin(String code, String encryptedData, String iv, HttpServletRequest request)
    {
        return epieService.login_by_weixin(code,encryptedData,iv,request);
    }

}
