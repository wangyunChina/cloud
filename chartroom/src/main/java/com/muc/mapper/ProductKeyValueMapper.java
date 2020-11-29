package com.muc.mapper;

import com.muc.bean.ProductKeyValue;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ProductKeyValueMapper {
    @Delete({
        "delete from product_keyvalue",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_keyvalue (id, pid, ",
        "gvalue, gstock)",
        "values (#{id,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER}, ",
        "#{gvalue,jdbcType=VARCHAR}, #{gstock,jdbcType=INTEGER})"
    })
    int insert(ProductKeyValue record);

    @InsertProvider(type= ProductKeyValueSqlProvider.class, method="insertSelective")
    int insertSelective(ProductKeyValue record);

    @Select({
        "select",
        "id, pid, gvalue, gstock",
        "from product_keyvalue",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="gvalue", property="gvalue", jdbcType=JdbcType.VARCHAR),
        @Result(column="gstock", property="gstock", jdbcType=JdbcType.INTEGER)
    })
    ProductKeyValue selectByPrimaryKey(Integer id);

    @UpdateProvider(type= ProductKeyValueSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductKeyValue record);

    @Update({
        "update product_keyvalue",
        "set pid = #{pid,jdbcType=INTEGER},",
          "gvalue = #{gvalue,jdbcType=VARCHAR},",
          "gstock = #{gstock,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductKeyValue record);
}