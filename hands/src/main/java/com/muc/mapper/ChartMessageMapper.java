package com.muc.mapper;

import com.muc.bean.ChartMessage;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ChartMessageMapper {
    @Delete({
        "delete from chart_message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into chart_message (id, message_from, ",
        "message_to, send_time, ",
        "message, isread)",
        "values (#{id,jdbcType=INTEGER}, #{messageFrom,jdbcType=VARCHAR}, ",
        "#{messageTo,jdbcType=VARCHAR}, #{sendTime,jdbcType=TIMESTAMP}, ",
        "#{message,jdbcType=VARCHAR}, #{isread,jdbcType=TINYINT})"
    })
    int insert(ChartMessage record);

    @InsertProvider(type= ChartMessageSqlProvider.class, method="insertSelective")
    int insertSelective(ChartMessage record);

    @Select({
        "select",
        "id, message_from, message_to, send_time, message, isread",
        "from chart_message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="message_from", property="messageFrom", jdbcType=JdbcType.VARCHAR),
        @Result(column="message_to", property="messageTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_time", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="isread", property="isread", jdbcType=JdbcType.TINYINT)
    })
    ChartMessage selectByPrimaryKey(Integer id);

    @UpdateProvider(type= ChartMessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ChartMessage record);

    @Update({
        "update chart_message",
        "set message_from = #{messageFrom,jdbcType=VARCHAR},",
          "message_to = #{messageTo,jdbcType=VARCHAR},",
          "send_time = #{sendTime,jdbcType=TIMESTAMP},",
          "message = #{message,jdbcType=VARCHAR},",
          "isread = #{isread,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ChartMessage record);
}