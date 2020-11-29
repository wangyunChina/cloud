package com.muc.mapper;

import com.muc.bean.Orders;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class OrdersSqlProvider {

    public String insertSelective(Orders record) {
        BEGIN();
        INSERT_INTO("orders");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getOnumber() != null) {
            VALUES("Onumber", "#{onumber,jdbcType=INTEGER}");
        }
        
        if (record.getOprice() != null) {
            VALUES("Oprice", "#{oprice,jdbcType=DOUBLE}");
        }
        
        if (record.getOpricein() != null) {
            VALUES("Opricein", "#{opricein,jdbcType=DOUBLE}");
        }
        
        if (record.getOdelivernumber() != null) {
            VALUES("OdeliverNumber", "#{odelivernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getAid() != null) {
            VALUES("Aid", "#{aid,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getOstatu() != null) {
            VALUES("Ostatu", "#{ostatu,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Orders record) {
        BEGIN();
        UPDATE("orders");
        
        if (record.getPid() != null) {
            SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getOnumber() != null) {
            SET("Onumber = #{onumber,jdbcType=INTEGER}");
        }
        
        if (record.getOprice() != null) {
            SET("Oprice = #{oprice,jdbcType=DOUBLE}");
        }
        
        if (record.getOpricein() != null) {
            SET("Opricein = #{opricein,jdbcType=DOUBLE}");
        }
        
        if (record.getOdelivernumber() != null) {
            SET("OdeliverNumber = #{odelivernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getAid() != null) {
            SET("Aid = #{aid,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getOstatu() != null) {
            SET("Ostatu = #{ostatu,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}