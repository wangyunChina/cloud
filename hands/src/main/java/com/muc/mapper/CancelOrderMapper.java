package com.muc.mapper;

import com.muc.bean.CancelOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CancelOrderMapper {
    @Delete({
        "delete from cancel_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into cancel_order (id, oid, ",
        "uid, isagree)",
        "values (#{id,jdbcType=INTEGER}, #{oid,jdbcType=INTEGER}, ",
        "#{uid,jdbcType=VARCHAR}, #{isagree,jdbcType=BIT})"
    })
    int insert(CancelOrder record);

    @InsertProvider(type= CancelOrderSqlProvider.class, method="insertSelective")
    int insertSelective(CancelOrder record);

    @Select({
        "select",
        "id, oid, uid, isagree",
        "from cancel_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="oid", property="oid", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR),
        @Result(column="isagree", property="isagree", jdbcType=JdbcType.BIT)
    })
    CancelOrder selectByPrimaryKey(Integer id);

    @UpdateProvider(type= CancelOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CancelOrder record);

    @Update({
        "update cancel_order",
        "set oid = #{oid,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=VARCHAR},",
          "isagree = #{isagree,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CancelOrder record);
}