package com.muc.bean;

import java.io.Serializable;

public class AcceptMessage implements Serializable {
    private Integer id;

    private String uid;

    private String aname;

    private String alocation;

    private String aphone;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getAlocation() {
        return alocation;
    }

    public void setAlocation(String alocation) {
        this.alocation = alocation == null ? null : alocation.trim();
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone == null ? null : aphone.trim();
    }
}