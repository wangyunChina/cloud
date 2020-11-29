package com.muc.zuul.entities;


import lombok.Data;

/**
 * @Author 王云
 * @Description 用户实体类
 */
@Data
public class User{
    private String cid;
    private String firstname;
    private String lastname;
    private String mobile;
    private String aesMobile;
    private String password;
}
