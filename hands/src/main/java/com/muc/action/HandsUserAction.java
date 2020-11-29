package com.muc.action;

import com.muc.bean.HandsUser;
import com.muc.service.HandsUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/hands")
public class HandsUserAction {
    @Resource HandsUserService handsUserService;
    @RequestMapping("/login")
    public HashMap<String,Object> login(String username, String password){
        HashMap<String,Object> map=new HashMap<>();
        HandsUser handsUser=new HandsUser();
        handsUser.setUsername(username);
        handsUser.setHandsPassword(password);
        HandsUser user = handsUserService.login(handsUser);
        if(user!=null)
        {
            map.put("result","success");
            map.put("data",user);
        }
        else{
            map.put("result","fail");
            map.put("errorMessage","用户不存在或密码错误！");
        }
        return map;
    }
    @RequestMapping("/reg")
    public HashMap<String,Object> register(String username,String password,String headImg)
    {
        HashMap<String,Object> map=new HashMap<>();
        HandsUser handsUser=new HandsUser();
        handsUser.setHeadimg(headImg);
        handsUser.setUsername(username);
        handsUser.setHandsPassword(password);
        int result=this.handsUserService.reg(handsUser);
        if(result==1)
        {
            map.put("result","success");
            map.put("data",result);
        }
        else{
            map.put("result","fail");
            map.put("errorMessage","该用户名已经被注册了，请通过手机号找回密码！");
        }
        return  map;
    }
}
