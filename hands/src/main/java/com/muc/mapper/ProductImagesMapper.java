package com.muc.mapper;

import com.muc.bean.ProductImages;
import com.muc.bean.ProductImagesKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface ProductImagesMapper {
    @Delete({
        "delete from productimages",
        "where pid = #{pid,jdbcType=INTEGER}",
          "and image = #{image,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(ProductImagesKey key);

    @Insert({
        "insert into productimages (pid, image, ",
        "orders)",
        "values (#{pid,jdbcType=INTEGER}, #{image,jdbcType=VARCHAR}, ",
        "#{orders,jdbcType=INTEGER})"
    })
    int insert(ProductImages record);

    @InsertProvider(type=ProductImagesSqlProvider.class, method="insertSelective")
    int insertSelective(ProductImages record);

    @Select({
        "select",
        "pid, image, orders",
        "from productimages",
        "where pid = #{pid,jdbcType=INTEGER}",
          "and image = #{image,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="orders", property="orders", jdbcType=JdbcType.INTEGER)
    })
    ProductImages selectByPrimaryKey(ProductImagesKey key);
    @Select({
            "select",
            "image",
            "from productimages",
            "where pid = #{pid,jdbcType=INTEGER}",
            "order by orders"
    })
    @Results({
            @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR, id=true)
    })
    ArrayList<String> selectByPid(Integer pid);

    @UpdateProvider(type=ProductImagesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductImages record);

    @Update({
        "update productimages",
        "set orders = #{orders,jdbcType=INTEGER}",
        "where pid = #{pid,jdbcType=INTEGER}",
          "and image = #{image,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ProductImages record);
}