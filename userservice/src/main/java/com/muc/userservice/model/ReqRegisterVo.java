package com.muc.userservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqRegisterVo {
    @ApiModelProperty(name = "姓",required = true)
    private String lastName;
    @ApiModelProperty(name = "名",required = true)
    private String firstname;
    @ApiModelProperty(name = "手机号",required = true)
    private String mobile;
    @ApiModelProperty(name = "密码",required = true)
    private String password;
    @ApiModelProperty(name = "昵称",required = true)
    private String nickName;
    @ApiModelProperty(name = "头像",required = true)
    private String avatarUrl;
}
