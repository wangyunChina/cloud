package com.muc.mapper;

import com.muc.bean.Sex;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class SexSqlProvider {

    public String insertSelective(Sex record) {
        BEGIN();
        INSERT_INTO("sex");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Sex record) {
        BEGIN();
        UPDATE("sex");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}