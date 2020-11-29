package com.muc.bean;

import java.io.Serializable;

public class ShopcartKey implements Serializable {
    private String cid;

    private Integer pid;

    private static final long serialVersionUID = 1L;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}