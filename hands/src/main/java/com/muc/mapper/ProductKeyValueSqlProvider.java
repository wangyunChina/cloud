package com.muc.mapper;

import com.muc.bean.ProductKeyValue;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProductKeyValueSqlProvider {

    public String insertSelective(ProductKeyValue record) {
        BEGIN();
        INSERT_INTO("product_keyvalue");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getGvalue() != null) {
            VALUES("gvalue", "#{gvalue,jdbcType=VARCHAR}");
        }
        
        if (record.getGstock() != null) {
            VALUES("gstock", "#{gstock,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ProductKeyValue record) {
        BEGIN();
        UPDATE("product_keyvalue");
        
        if (record.getPid() != null) {
            SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getGvalue() != null) {
            SET("gvalue = #{gvalue,jdbcType=VARCHAR}");
        }
        
        if (record.getGstock() != null) {
            SET("gstock = #{gstock,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}