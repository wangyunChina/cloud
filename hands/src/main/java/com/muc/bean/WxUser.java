package com.muc.bean;

import java.io.Serializable;

public class WxUser implements Serializable {
    private String wxid;

    private String username;

    private static final long serialVersionUID = 1L;

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid == null ? null : wxid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}