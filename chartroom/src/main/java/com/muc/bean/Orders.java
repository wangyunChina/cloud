package com.muc.bean;

import java.io.Serializable;

public class Orders implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer onumber;

    private Double oprice;

    private Double opricein;

    private String odelivernumber;

    private Integer aid;

    private String uid;

    private Integer ostatu;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOnumber() {
        return onumber;
    }

    public void setOnumber(Integer onumber) {
        this.onumber = onumber;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public Double getOpricein() {
        return opricein;
    }

    public void setOpricein(Double opricein) {
        this.opricein = opricein;
    }

    public String getOdelivernumber() {
        return odelivernumber;
    }

    public void setOdelivernumber(String odelivernumber) {
        this.odelivernumber = odelivernumber == null ? null : odelivernumber.trim();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getOstatu() {
        return ostatu;
    }

    public void setOstatu(Integer ostatu) {
        this.ostatu = ostatu;
    }
}