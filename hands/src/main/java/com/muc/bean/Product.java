package com.muc.bean;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;

    private String pname;

    private Double ppricein;

    private Integer pstack;

    private String uid;

    private String author;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getPpricein() {
        return ppricein;
    }

    public void setPpricein(Double ppricein) {
        this.ppricein = ppricein;
    }

    public Integer getPstack() {
        return pstack;
    }

    public void setPstack(Integer pstack) {
        this.pstack = pstack;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }
}