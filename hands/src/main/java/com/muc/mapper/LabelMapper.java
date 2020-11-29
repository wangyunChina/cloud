package com.muc.mapper;

import com.muc.bean.Label;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface LabelMapper {
    @Delete({
        "delete from label",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into label (id, val)",
        "values (#{id,jdbcType=INTEGER}, #{val,jdbcType=VARCHAR})"
    })
    int insert(Label record);

    @InsertProvider(type= LabelSqlProvider.class, method="insertSelective")
    int insertSelective(Label record);

    @Select({
        "select",
        "id, val",
        "from label",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="val", property="val", jdbcType=JdbcType.VARCHAR)
    })
    Label selectByPrimaryKey(Integer id);

    @UpdateProvider(type= LabelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Label record);

    @Update({
        "update label",
        "set val = #{val,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Label record);
}