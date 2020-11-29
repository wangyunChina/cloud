package com.muc.mapper;

import com.muc.bean.Sex;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface SexMapper {
    @Delete({
        "delete from sex",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sex (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(Sex record);

    @InsertProvider(type= SexSqlProvider.class, method="insertSelective")
    int insertSelective(Sex record);

    @Select({
        "select",
        "id, val",
        "from sex",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    Sex selectByPrimaryKey(Integer id);

    @UpdateProvider(type= SexSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sex record);

    @Update({
        "update sex",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sex record);
}