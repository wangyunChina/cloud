package com.muc.mapper;

import com.muc.bean.OrderStatus;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class OrderStatusSqlProvider {

    public String insertSelective(OrderStatus record) {
        BEGIN();
        INSERT_INTO("orderstatus");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVal() != null) {
            VALUES("val", "#{val,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderStatus record) {
        BEGIN();
        UPDATE("orderstatus");
        
        if (record.getVal() != null) {
            SET("val = #{val,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}