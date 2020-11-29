package com.muc.bean;

import java.io.Serializable;

public class UserSelect extends UserSelectKey implements Serializable {
    private Integer now;

    private static final long serialVersionUID = 1L;

    public Integer getNow() {
        return now;
    }

    public void setNow(Integer now) {
        this.now = now;
    }
}