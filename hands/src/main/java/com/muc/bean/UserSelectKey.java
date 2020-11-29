package com.muc.bean;

import java.io.Serializable;

public class UserSelectKey implements Serializable {
    private String wxid;

    private Integer bookid;

    private static final long serialVersionUID = 1L;

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid == null ? null : wxid.trim();
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
}