package com.muc.userservice.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserCardTypeEnum {
    NOMAL("1111100"),
    VIP("1111110"),
    DEALER("1111111");
    private String power;
}
