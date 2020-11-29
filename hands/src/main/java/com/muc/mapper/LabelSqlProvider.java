package com.muc.mapper;

import com.muc.bean.Label;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class LabelSqlProvider {

    public String insertSelective(Label record) {
        BEGIN();
        INSERT_INTO("label");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Label record) {
        BEGIN();
        UPDATE("label");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}