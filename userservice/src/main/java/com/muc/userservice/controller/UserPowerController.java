package com.muc.userservice.controller;

import com.muc.userservice.model.ReqRegisterVo;
import com.muc.userservice.model.Result;
import com.muc.userservice.model.ResultGenerator;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userpower/api")
@Api(value = "用户权限管理")
@Slf4j
public class UserPowerController extends BaseController{
    public Result getUserPower(@RequestBody ReqRegisterVo request)
    {
        return null;
    }
    public Result updateUserPower(@RequestBody ReqRegisterVo request)
    {
        return null;
    }
}
