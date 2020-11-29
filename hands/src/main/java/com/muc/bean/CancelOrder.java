package com.muc.bean;

import java.io.Serializable;

public class CancelOrder implements Serializable {
    private Integer id;

    private Integer oid;

    private String uid;

    private Boolean isagree;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Boolean getIsagree() {
        return isagree;
    }

    public void setIsagree(Boolean isagree) {
        this.isagree = isagree;
    }
}