package com.muc.mapper;

import com.muc.bean.WxUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface WxUserMapper {
    @Delete({
        "delete from wxuser",
        "where wxid = #{wxid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String wxid);

    @Insert({
        "insert into wxuser (wxid, username)",
        "values (#{wxid,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR})"
    })
    int insert(WxUser record);

    @InsertProvider(type=WxUserSqlProvider.class, method="insertSelective")
    int insertSelective(WxUser record);

    @Select({
        "select",
        "wxid, username",
        "from wxuser",
        "where wxid = #{wxid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="wxid", property="wxid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR)
    })
    WxUser selectByPrimaryKey(String wxid);

    @UpdateProvider(type=WxUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WxUser record);

    @Update({
        "update wxuser",
        "set username = #{username,jdbcType=VARCHAR}",
        "where wxid = #{wxid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(WxUser record);
}