package com.muc.communityservice.consts;

public enum RetEnum {
    SUCCESS(200,"success"),
    INTERNAL_ERROR(500, "内部异常"),
    TOKEN_VERIFY_FAIL(401,"token认证失败"),
    PARAM_ERROR(501,"参数异常"),
    FILE_SIZE_ERROR(201,"文件大小异常"),
    THIRD_PARTY_BUSINESS_ERROR_CODE(299,"第三方信息错误码");


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
