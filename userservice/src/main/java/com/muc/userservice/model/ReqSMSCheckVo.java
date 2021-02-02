package com.muc.userservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqSMSCheckVo {
    @ApiModelProperty(name = "手机号")
    private String mobile;
    @ApiModelProperty(name = "验证码")
    private String code;
}
