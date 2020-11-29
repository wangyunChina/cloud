package com.muc.bean;

import java.io.Serializable;
import java.util.Date;

public class HandsUser implements Serializable {
    private String username;

    private String handsPassword;

    private String fakename;

    private Boolean sex;

    private Date birthday;

    private String headimg;

    private Double money;

    private String phone;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getHandsPassword() {
        return handsPassword;
    }

    public void setHandsPassword(String handsPassword) {
        this.handsPassword = handsPassword == null ? null : handsPassword.trim();
    }

    public String getFakename() {
        return fakename;
    }

    public void setFakename(String fakename) {
        this.fakename = fakename == null ? null : fakename.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}