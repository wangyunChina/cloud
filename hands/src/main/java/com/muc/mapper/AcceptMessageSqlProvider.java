package com.muc.mapper;

import com.muc.bean.AcceptMessage;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class AcceptMessageSqlProvider {

    public String insertSelective(AcceptMessage record) {
        BEGIN();
        INSERT_INTO("accept_message");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getAname() != null) {
            VALUES("aname", "#{aname,jdbcType=VARCHAR}");
        }
        
        if (record.getAlocation() != null) {
            VALUES("alocation", "#{alocation,jdbcType=VARCHAR}");
        }
        
        if (record.getAphone() != null) {
            VALUES("Aphone", "#{aphone,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(AcceptMessage record) {
        BEGIN();
        UPDATE("accept_message");
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getAname() != null) {
            SET("aname = #{aname,jdbcType=VARCHAR}");
        }
        
        if (record.getAlocation() != null) {
            SET("alocation = #{alocation,jdbcType=VARCHAR}");
        }
        
        if (record.getAphone() != null) {
            SET("Aphone = #{aphone,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}