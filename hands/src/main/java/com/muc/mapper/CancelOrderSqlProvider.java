package com.muc.mapper;

import com.muc.bean.CancelOrder;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class CancelOrderSqlProvider {

    public String insertSelective(CancelOrder record) {
        BEGIN();
        INSERT_INTO("cancel_order");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getOid() != null) {
            VALUES("oid", "#{oid,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            VALUES("uid", "#{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getIsagree() != null) {
            VALUES("isagree", "#{isagree,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CancelOrder record) {
        BEGIN();
        UPDATE("cancel_order");
        
        if (record.getOid() != null) {
            SET("oid = #{oid,jdbcType=INTEGER}");
        }
        
        if (record.getUid() != null) {
            SET("uid = #{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getIsagree() != null) {
            SET("isagree = #{isagree,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}