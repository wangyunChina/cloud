package com.muc.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.muc.bean.UserSelect;

public class UserSelectSqlProvider {

    public String insertSelective(UserSelect record) {
        BEGIN();
        INSERT_INTO("user_select");
        
        if (record.getWxid() != null) {
            VALUES("wxid", "#{wxid,jdbcType=VARCHAR}");
        }
        
        if (record.getBookid() != null) {
            VALUES("bookid", "#{bookid,jdbcType=INTEGER}");
        }
        
        if (record.getNow() != null) {
            VALUES("now", "#{now,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserSelect record) {
        BEGIN();
        UPDATE("user_select");
        
        if (record.getNow() != null) {
            SET("now = #{now,jdbcType=INTEGER}");
        }
        
        WHERE("wxid = #{wxid,jdbcType=VARCHAR}");
        WHERE("bookid = #{bookid,jdbcType=INTEGER}");
        
        return SQL();
    }
}