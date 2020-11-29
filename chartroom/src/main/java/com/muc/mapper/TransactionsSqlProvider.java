package com.muc.mapper;

import com.muc.bean.Transactions;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TransactionsSqlProvider {

    public String insertSelective(Transactions record) {
        BEGIN();
        INSERT_INTO("transactions");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getInuid() != null) {
            VALUES("inuid", "#{inuid,jdbcType=VARCHAR}");
        }
        
        if (record.getOutuid() != null) {
            VALUES("outuid", "#{outuid,jdbcType=VARCHAR}");
        }
        
        if (record.getTransactionAmount() != null) {
            VALUES("transaction_amount", "#{transactionAmount,jdbcType=DOUBLE}");
        }
        
        if (record.getTtime() != null) {
            VALUES("ttime", "#{ttime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Transactions record) {
        BEGIN();
        UPDATE("transactions");
        
        if (record.getInuid() != null) {
            SET("inuid = #{inuid,jdbcType=VARCHAR}");
        }
        
        if (record.getOutuid() != null) {
            SET("outuid = #{outuid,jdbcType=VARCHAR}");
        }
        
        if (record.getTransactionAmount() != null) {
            SET("transaction_amount = #{transactionAmount,jdbcType=DOUBLE}");
        }
        
        if (record.getTtime() != null) {
            SET("ttime = #{ttime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}