package com.muc.bean;

import java.io.Serializable;

public class ShopCart extends ShopCartKey implements Serializable {
    private Integer pnumber;

    private Double pcount;

    private static final long serialVersionUID = 1L;

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Double getPcount() {
        return pcount;
    }

    public void setPcount(Double pcount) {
        this.pcount = pcount;
    }
}