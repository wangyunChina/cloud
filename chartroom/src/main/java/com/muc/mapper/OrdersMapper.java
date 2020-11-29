package com.muc.mapper;

import com.muc.bean.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface OrdersMapper {
    @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orders (id, pid, ",
        "Onumber, Oprice, ",
        "Opricein, OdeliverNumber, ",
        "Aid, uid, Ostatu)",
        "values (#{id,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER}, ",
        "#{onumber,jdbcType=INTEGER}, #{oprice,jdbcType=DOUBLE}, ",
        "#{opricein,jdbcType=DOUBLE}, #{odelivernumber,jdbcType=VARCHAR}, ",
        "#{aid,jdbcType=INTEGER}, #{uid,jdbcType=VARCHAR}, #{ostatu,jdbcType=INTEGER})"
    })
    int insert(Orders record);

    @InsertProvider(type=OrdersSqlProvider.class, method="insertSelective")
    int insertSelective(Orders record);

    @Select({
        "select",
        "id, pid, Onumber, Oprice, Opricein, OdeliverNumber, Aid, uid, Ostatu",
        "from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="Onumber", property="onumber", jdbcType=JdbcType.INTEGER),
        @Result(column="Oprice", property="oprice", jdbcType=JdbcType.DOUBLE),
        @Result(column="Opricein", property="opricein", jdbcType=JdbcType.DOUBLE),
        @Result(column="OdeliverNumber", property="odelivernumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="Aid", property="aid", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Ostatu", property="ostatu", jdbcType=JdbcType.INTEGER)
    })
    Orders selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Orders record);

    @Update({
        "update orders",
        "set pid = #{pid,jdbcType=INTEGER},",
          "Onumber = #{onumber,jdbcType=INTEGER},",
          "Oprice = #{oprice,jdbcType=DOUBLE},",
          "Opricein = #{opricein,jdbcType=DOUBLE},",
          "OdeliverNumber = #{odelivernumber,jdbcType=VARCHAR},",
          "Aid = #{aid,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=VARCHAR},",
          "Ostatu = #{ostatu,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Orders record);
}