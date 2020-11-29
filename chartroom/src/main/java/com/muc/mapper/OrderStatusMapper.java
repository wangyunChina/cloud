package com.muc.mapper;

import com.muc.bean.OrderStatus;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface OrderStatusMapper {
    @Delete({
        "delete from orderstatus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orderstatus (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(OrderStatus record);

    @InsertProvider(type=OrderStatusSqlProvider.class, method="insertSelective")
    int insertSelective(OrderStatus record);

    @Select({
        "select",
        "id, val",
        "from orderstatus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    OrderStatus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrderStatusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderStatus record);

    @Update({
        "update orderstatus",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderStatus record);
}