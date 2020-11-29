package com.muc.mapper;

import com.muc.bean.UserSelect;
import com.muc.bean.UserSelectKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;

public interface UserSelectMapper {
    @Delete({
        "delete from user_select",
        "where wxid = #{wxid,jdbcType=VARCHAR}",
          "and bookid = #{bookid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(UserSelectKey key);

    @Insert({
        "insert into user_select (wxid, bookid, ",
        "now)",
        "values (#{wxid,jdbcType=VARCHAR}, #{bookid,jdbcType=INTEGER}, ",
        "#{now,jdbcType=INTEGER})"
    })
    int insert(UserSelect record);

    @InsertProvider(type=UserSelectSqlProvider.class, method="insertSelective")
    int insertSelective(UserSelect record);

    @Select({
        "select",
        "wxid, bookid, now",
        "from user_select",
        "where wxid = #{wxid,jdbcType=VARCHAR}",
          "and bookid = #{bookid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="wxid", property="wxid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="bookid", property="bookid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="now", property="now", jdbcType=JdbcType.INTEGER)
    })
    UserSelect selectByPrimaryKey(UserSelectKey key);
    @Select({
            "select",
            "wxid, bookid, now",
            "from user_select",
            "where wxid = #{wxid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="wxid", property="wxid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="bookid", property="bookid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="now", property="now", jdbcType=JdbcType.INTEGER)
    })
    ArrayList<UserSelect> selectByWxid(String wxid);

    @UpdateProvider(type=UserSelectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserSelect record);

    @Update({
        "update user_select",
        "set now = #{now,jdbcType=INTEGER}",
        "where wxid = #{wxid,jdbcType=VARCHAR}",
          "and bookid = #{bookid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserSelect record);
}