package com.muc.bean;

import java.io.Serializable;
import java.util.Date;

public class Transactions implements Serializable {
    private Integer id;

    private String inuid;

    private String outuid;

    private Double transactionAmount;

    private Date ttime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInuid() {
        return inuid;
    }

    public void setInuid(String inuid) {
        this.inuid = inuid == null ? null : inuid.trim();
    }

    public String getOutuid() {
        return outuid;
    }

    public void setOutuid(String outuid) {
        this.outuid = outuid == null ? null : outuid.trim();
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }
}