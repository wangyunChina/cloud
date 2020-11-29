package com.muc.mapper;

import com.muc.bean.AcceptMessage;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface AcceptMessageMapper {
    @Delete({
        "delete from accept_message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into accept_message (id, uid, ",
        "aname, alocation, ",
        "Aphone)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=VARCHAR}, ",
        "#{aname,jdbcType=VARCHAR}, #{alocation,jdbcType=VARCHAR}, ",
        "#{aphone,jdbcType=VARCHAR})"
    })
    int insert(AcceptMessage record);

    @InsertProvider(type=AcceptMessageSqlProvider.class, method="insertSelective")
    int insertSelective(AcceptMessage record);

    @Select({
        "select",
        "id, uid, aname, alocation, Aphone",
        "from accept_message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR),
        @Result(column="aname", property="aname", jdbcType=JdbcType.VARCHAR),
        @Result(column="alocation", property="alocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="Aphone", property="aphone", jdbcType=JdbcType.VARCHAR)
    })
    AcceptMessage selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AcceptMessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AcceptMessage record);

    @Update({
        "update accept_message",
        "set uid = #{uid,jdbcType=VARCHAR},",
          "aname = #{aname,jdbcType=VARCHAR},",
          "alocation = #{alocation,jdbcType=VARCHAR},",
          "Aphone = #{aphone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AcceptMessage record);
}