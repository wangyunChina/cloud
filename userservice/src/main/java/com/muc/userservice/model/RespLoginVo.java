package com.muc.userservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespLoginVo {
    @ApiModelProperty(name = "id")
    private String cid;
    @ApiModelProperty(name = "手机号")
    private String mobile;
    @ApiModelProperty(name = "token")
    private String apiToken;
    @ApiModelProperty(name ="有效时间")
    private long   expireTime;
    @ApiModelProperty(name ="昵称")
    private String nickName;
    @ApiModelProperty(name ="头像")
    private String avatar;

}
