package com.muc.userservice.consts;

public enum RetEnum {
    SUCCESS(200,"success"),
    INTERNAL_ERROR(500, "内部异常"),
    //SMS
    CODE_ERROR(601,"验证码不正确"),
    USER_NOT_EXIST(600,"该手机号还未注册"),
    DOUBLE_CLICK(602,"验证码已经发送，请不要重复点击")
    ;

    private int code;
    private String message;

    private RetEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static RetEnum getRetEnum(int code) {
        if (code == 0) {
            return null;
        }

        RetEnum[] values = RetEnum.values();
        for (RetEnum e : values) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
