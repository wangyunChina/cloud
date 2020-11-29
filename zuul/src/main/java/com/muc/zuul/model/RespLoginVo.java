package com.muc.zuul.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespLoginVo {
    private String cid;

    private String mobile;

    private String apiToken;

    private long   expireTime;

    private String nickName;

    private String avatar;

}
