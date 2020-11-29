package com.muc.mapper;

import com.muc.bean.TypeLevel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface TypeLevelMapper {
    @Delete({
        "delete from type_level",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into type_level (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(TypeLevel record);

    @InsertProvider(type=TypeLevelSqlProvider.class, method="insertSelective")
    int insertSelective(TypeLevel record);

    @Select({
        "select",
        "id, val",
        "from type_level",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    TypeLevel selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TypeLevelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TypeLevel record);

    @Update({
        "update type_level",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TypeLevel record);
}