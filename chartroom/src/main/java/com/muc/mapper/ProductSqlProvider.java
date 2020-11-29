package com.muc.mapper;

import com.muc.bean.Product;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProductSqlProvider {

    public String insertSelective(Product record) {
        BEGIN();
        INSERT_INTO("product");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPname() != null) {
            VALUES("pname", "#{pname,jdbcType=VARCHAR}");
        }
        
        if (record.getPpricein() != null) {
            VALUES("ppricein", "#{ppricein,jdbcType=DOUBLE}");
        }
        
        if (record.getPstack() != null) {
            VALUES("pstack", "#{pstack,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            VALUES("author", "#{author,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Product record) {
        BEGIN();
        UPDATE("product");
        
        if (record.getPname() != null) {
            SET("pname = #{pname,jdbcType=VARCHAR}");
        }
        
        if (record.getPpricein() != null) {
            SET("ppricein = #{ppricein,jdbcType=DOUBLE}");
        }
        
        if (record.getPstack() != null) {
            SET("pstack = #{pstack,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthor() != null) {
            SET("author = #{author,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}