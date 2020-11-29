package com.muc.mapper;

import com.muc.bean.TypeLevel;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TypeLevelSqlProvider {

    public String insertSelective(TypeLevel record) {
        BEGIN();
        INSERT_INTO("type_level");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(TypeLevel record) {
        BEGIN();
        UPDATE("type_level");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}