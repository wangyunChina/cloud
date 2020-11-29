package com.muc.bean;

import java.io.Serializable;

public class Orders extends OrdersKey implements Serializable {
    private Integer aid;

    private static final long serialVersionUID = 1L;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}