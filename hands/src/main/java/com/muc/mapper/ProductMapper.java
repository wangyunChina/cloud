package com.muc.mapper;

import com.muc.bean.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface ProductMapper {
    @Delete({
        "delete from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product (id, pname, ",
        "ppricein, pstack, ",
        "uid, author)",
        "values (#{id,jdbcType=INTEGER}, #{pname,jdbcType=VARCHAR}, ",
        "#{ppricein,jdbcType=DOUBLE}, #{pstack,jdbcType=INTEGER}, ",
        "#{uid,jdbcType=VARCHAR}, #{author,jdbcType=VARCHAR})"
    })
    int insert(Product record);

    @InsertProvider(type= ProductSqlProvider.class, method="insertSelective")
    int insertSelective(Product record);

    @Select({
        "select",
        "id, pname, ppricein, pstack, uid, author",
        "from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pname", property="pname", jdbcType=JdbcType.VARCHAR),
        @Result(column="ppricein", property="ppricein", jdbcType=JdbcType.DOUBLE),
        @Result(column="pstack", property="pstack", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR)
    })
    Product selectByPrimaryKey(Integer id);
    @Select({
            "select",
            "id, pname, ppricein, pstack, uid, author",
            "from product",
            "limit 30"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="pname", property="pname", jdbcType=JdbcType.VARCHAR),
            @Result(column="ppricein", property="ppricein", jdbcType=JdbcType.DOUBLE),
            @Result(column="pstack", property="pstack", jdbcType=JdbcType.INTEGER),
            @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR),
            @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<Product> selectAll();

    @UpdateProvider(type= ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update product",
        "set pname = #{pname,jdbcType=VARCHAR},",
          "ppricein = #{ppricein,jdbcType=DOUBLE},",
          "pstack = #{pstack,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}