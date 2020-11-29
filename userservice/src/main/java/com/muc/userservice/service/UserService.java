package com.muc.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muc.userservice.entity.User;
import com.muc.userservice.model.ReqLoginVo;
import com.muc.userservice.model.ReqRegisterVo;
import com.muc.userservice.model.RespLoginVo;
import com.muc.userservice.model.Result;

public interface UserService  {
    public int register(ReqRegisterVo request);
    public Result<RespLoginVo> login(ReqLoginVo reqLoginVo);
}
