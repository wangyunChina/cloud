package com.muc.action;

import com.muc.service.ChartMessageService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.stream.FactoryConfigurationError;
import java.util.HashMap;

@RequestMapping("/hands")
@RestController
@CrossOrigin
public class HomeAction {
    @Resource
    ChartMessageService chartMessageService;
    @RequestMapping("/myMessage")
    public HashMap getNotReadMessage(String username){
        return  chartMessageService.readAllNotReadMessage(username);
    }
    @RequestMapping("/messageFrom")
    public HashMap getMessageFromUser(String send,String acept)
    {
        return this.chartMessageService.readMessage(send, acept);
    }
}
