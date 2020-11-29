package com.muc.userservice.controller;

import com.muc.userservice.entity.User;
import com.muc.userservice.model.*;
import com.muc.userservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api")
@Api(value = "用户管理")
@Slf4j
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @PostMapping("/v1/register")
    @ApiOperation("注册")
    public Result register(@RequestBody ReqRegisterVo request)
    {
        return ResultGenerator.genSuccessResult(userService.register(request));
    }
    @PostMapping("/v1/login")
    @ApiOperation("登录")
    public Result<RespLoginVo> login(@RequestBody ReqLoginVo request)
    {
        return userService.login(request);
    }
}
