package com.muc.mapper;

import com.muc.bean.ChartMessage;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ChartMessageSqlProvider {

    public String insertSelective(ChartMessage record) {
        BEGIN();
        INSERT_INTO("chart_message");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMessageFrom() != null) {
            VALUES("message_from", "#{messageFrom,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageTo() != null) {
            VALUES("message_to", "#{messageTo,jdbcType=VARCHAR}");
        }
        
        if (record.getSendTime() != null) {
            VALUES("send_time", "#{sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMessage() != null) {
            VALUES("message", "#{message,jdbcType=VARCHAR}");
        }
        
        if (record.getIsread() != null) {
            VALUES("isread", "#{isread,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ChartMessage record) {
        BEGIN();
        UPDATE("chart_message");
        
        if (record.getMessageFrom() != null) {
            SET("message_from = #{messageFrom,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageTo() != null) {
            SET("message_to = #{messageTo,jdbcType=VARCHAR}");
        }
        
        if (record.getSendTime() != null) {
            SET("send_time = #{sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{message,jdbcType=VARCHAR}");
        }
        
        if (record.getIsread() != null) {
            SET("isread = #{isread,jdbcType=TINYINT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}