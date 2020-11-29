package com.muc.mapper;

import com.muc.bean.ProductImages;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProductImagesSqlProvider {

    public String insertSelective(ProductImages record) {
        BEGIN();
        INSERT_INTO("productimages");
        
        if (record.getPid() != null) {
            VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getOrders() != null) {
            VALUES("orders", "#{orders,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ProductImages record) {
        BEGIN();
        UPDATE("productimages");
        
        if (record.getOrders() != null) {
            SET("orders = #{orders,jdbcType=INTEGER}");
        }
        
        WHERE("pid = #{pid,jdbcType=INTEGER}");
        WHERE("image = #{image,jdbcType=VARCHAR}");
        
        return SQL();
    }
}