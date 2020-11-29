package com.muc.bean;

import java.io.Serializable;

public class ProductTypeKey implements Serializable {
    private Integer pid;

    private Integer tid;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}