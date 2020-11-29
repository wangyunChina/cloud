package com.muc.mapper;

import com.muc.bean.ProductTypeKey;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProductTypeSqlProvider {

    public String insertSelective(ProductTypeKey record) {
        BEGIN();
        INSERT_INTO("product_type");
        
        if (record.getPid() != null) {
            VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getTid() != null) {
            VALUES("tid", "#{tid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }
}