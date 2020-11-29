package com.muc.bean;

import java.io.Serializable;

public class ProductImages extends ProductImagesKey implements Serializable {
    private Integer orders;

    private static final long serialVersionUID = 1L;

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}