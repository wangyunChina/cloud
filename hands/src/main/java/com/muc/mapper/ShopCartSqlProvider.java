package com.muc.mapper;

import com.muc.bean.ShopCart;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ShopCartSqlProvider {

    public String insertSelective(ShopCart record) {
        BEGIN();
        INSERT_INTO("shop_cart");
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getPnumber() != null) {
            VALUES("pnumber", "#{pnumber,jdbcType=INTEGER}");
        }
        
        if (record.getPcount() != null) {
            VALUES("pcount", "#{pcount,jdbcType=DOUBLE}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ShopCart record) {
        BEGIN();
        UPDATE("shop_cart");
        
        if (record.getPnumber() != null) {
            SET("pnumber = #{pnumber,jdbcType=INTEGER}");
        }
        
        if (record.getPcount() != null) {
            SET("pcount = #{pcount,jdbcType=DOUBLE}");
        }
        
        WHERE("uid = #{uid,jdbcType=VARCHAR}");
        WHERE("pid = #{pid,jdbcType=INTEGER}");
        
        return SQL();
    }
}