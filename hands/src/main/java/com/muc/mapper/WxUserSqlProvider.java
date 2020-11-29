package com.muc.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.muc.bean.WxUser;

public class WxUserSqlProvider {

    public String insertSelective(WxUser record) {
        BEGIN();
        INSERT_INTO("wxuser");
        
        if (record.getWxid() != null) {
            VALUES("wxid", "#{wxid,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(WxUser record) {
        BEGIN();
        UPDATE("wxuser");
        
        if (record.getUsername() != null) {
            SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        WHERE("wxid = #{wxid,jdbcType=VARCHAR}");
        
        return SQL();
    }
}