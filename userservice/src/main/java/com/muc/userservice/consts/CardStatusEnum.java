package com.muc.userservice.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardStatusEnum {
    CREATE("已创建",50),
    BIND("已绑定",51),
    TIMEOUT("已到期",52);
    private String message;
    private int value;

}
