package com.muc.userservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqSMSSendVo {
    @ApiModelProperty(name = "手机号")
    private String mobile;
}
