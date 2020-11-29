package com.muc.communityservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqLoginVo {
    @ApiModelProperty(name = "手机号")
    private String mobile;
    @ApiModelProperty(name = "密码")
    private String password;

}
