package com.muc.bean;

import java.io.Serializable;
import java.util.Date;

public class Shopcart extends ShopcartKey implements Serializable {
    private Integer shuliang;

    private Date shijian;

    private static final long serialVersionUID = 1L;

    public Integer getShuliang() {
        return shuliang;
    }

    public void setShuliang(Integer shuliang) {
        this.shuliang = shuliang;
    }

    public Date getShijian() {
        return shijian;
    }

    public void setShijian(Date shijian) {
        this.shijian = shijian;
    }
}