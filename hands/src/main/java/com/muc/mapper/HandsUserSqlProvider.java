package com.muc.mapper;

import com.muc.bean.HandsUser;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class HandsUserSqlProvider {

    public String insertSelective(HandsUser record) {
        BEGIN();
        INSERT_INTO("handsuser");
        
        if (record.getUsername() != null) {
            VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getHandsPassword() != null) {
            VALUES("hands_password", "#{handsPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getFakename() != null) {
            VALUES("fakename", "#{fakename,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            VALUES("sex", "#{sex,jdbcType=BIT}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=DATE}");
        }
        
        if (record.getHeadimg() != null) {
            VALUES("headImg", "#{headimg,jdbcType=VARCHAR}");
        }
        
        if (record.getMoney() != null) {
            VALUES("money", "#{money,jdbcType=DOUBLE}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(HandsUser record) {
        BEGIN();
        UPDATE("handsuser");
        
        if (record.getHandsPassword() != null) {
            SET("hands_password = #{handsPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getFakename() != null) {
            SET("fakename = #{fakename,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("sex = #{sex,jdbcType=BIT}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=DATE}");
        }
        
        if (record.getHeadimg() != null) {
            SET("headImg = #{headimg,jdbcType=VARCHAR}");
        }
        
        if (record.getMoney() != null) {
            SET("money = #{money,jdbcType=DOUBLE}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        WHERE("username = #{username,jdbcType=VARCHAR}");
        
        return SQL();
    }
}