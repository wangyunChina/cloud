package com.muc.mapper;

import com.muc.bean.ShopCart;
import com.muc.bean.ShopCartKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ShopCartMapper {
    @Delete({
        "delete from shop_cart",
        "where uid = #{uid,jdbcType=VARCHAR}",
          "and pid = #{pid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(ShopCartKey key);

    @Insert({
        "insert into shop_cart (uid, pid, ",
        "pnumber, pcount)",
        "values (#{uid,jdbcType=VARCHAR}, #{pid,jdbcType=INTEGER}, ",
        "#{pnumber,jdbcType=INTEGER}, #{pcount,jdbcType=DOUBLE})"
    })
    int insert(ShopCart record);

    @InsertProvider(type=ShopCartSqlProvider.class, method="insertSelective")
    int insertSelective(ShopCart record);

    @Select({
        "select",
        "uid, pid, pnumber, pcount",
        "from shop_cart",
        "where uid = #{uid,jdbcType=VARCHAR}",
          "and pid = #{pid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pnumber", property="pnumber", jdbcType=JdbcType.INTEGER),
        @Result(column="pcount", property="pcount", jdbcType=JdbcType.DOUBLE)
    })
    ShopCart selectByPrimaryKey(ShopCartKey key);

    @UpdateProvider(type=ShopCartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopCart record);

    @Update({
        "update shop_cart",
        "set pnumber = #{pnumber,jdbcType=INTEGER},",
          "pcount = #{pcount,jdbcType=DOUBLE}",
        "where uid = #{uid,jdbcType=VARCHAR}",
          "and pid = #{pid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShopCart record);
}