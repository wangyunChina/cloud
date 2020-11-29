package com.muc.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.muc.bean.Book;

public class BookSqlProvider {

    public String insertSelective(Book record) {
        BEGIN();
        INSERT_INTO("book");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal() != null) {
            VALUES("total", "#{total,jdbcType=INTEGER}");
        }
        
        if (record.getDescs() != null) {
            VALUES("descs", "#{descs,jdbcType=VARCHAR}");
        }
        
        if (record.getSrc() != null) {
            VALUES("src", "#{src,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Book record) {
        BEGIN();
        UPDATE("book");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getTotal() != null) {
            SET("total = #{total,jdbcType=INTEGER}");
        }
        
        if (record.getDescs() != null) {
            SET("descs = #{descs,jdbcType=VARCHAR}");
        }
        
        if (record.getSrc() != null) {
            SET("src = #{src,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}