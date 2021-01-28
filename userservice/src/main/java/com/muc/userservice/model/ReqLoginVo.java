package com.muc.userservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqLoginVo {
    @ApiModelProperty(name = "手机号")
    private String mobile;
    @ApiModelProperty(name = "密码")
    private String password;
    @ApiModelProperty(name = "验证码")
    private String code;
    @ApiModelProperty(name = "登录方式 1-密码登录 2-验证码登录")
    private int mode;


}
