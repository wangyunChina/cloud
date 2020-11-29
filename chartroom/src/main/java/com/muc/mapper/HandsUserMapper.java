package com.muc.mapper;

import com.muc.bean.HandsUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface HandsUserMapper {
    @Delete({
        "delete from handsuser",
        "where username = #{username,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String username);

    @Insert({
        "insert into handsuser (username, hands_password, ",
        "fakename, sex, birthday, ",
        "headImg, money, phone)",
        "values (#{username,jdbcType=VARCHAR}, #{handsPassword,jdbcType=VARCHAR}, ",
        "#{fakename,jdbcType=VARCHAR}, #{sex,jdbcType=BIT}, #{birthday,jdbcType=DATE}, ",
        "#{headimg,jdbcType=VARCHAR}, #{money,jdbcType=DOUBLE}, #{phone,jdbcType=VARCHAR})"
    })
    int insert(HandsUser record);

    @InsertProvider(type= HandsUserSqlProvider.class, method="insertSelective")
    int insertSelective(HandsUser record);

    @Select({
        "select",
        "username, hands_password, fakename, sex, birthday, headImg, money, phone",
        "from handsuser",
        "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="hands_password", property="handsPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="fakename", property="fakename", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="headImg", property="headimg", jdbcType=JdbcType.VARCHAR),
        @Result(column="money", property="money", jdbcType=JdbcType.DOUBLE),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    HandsUser selectByPrimaryKey(String username);
    @Select({
            "select",
            "username, hands_password, fakename, sex, birthday, headImg, money, phone",
            "from handsuser",
            "where username = #{username,jdbcType=VARCHAR}",
            "and hands_password =#{password,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="hands_password", property="handsPassword", jdbcType=JdbcType.VARCHAR),
            @Result(column="fakename", property="fakename", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
            @Result(column="headImg", property="headimg", jdbcType=JdbcType.VARCHAR),
            @Result(column="money", property="money", jdbcType=JdbcType.DOUBLE),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    HandsUser selectToLogin(String username, String password);
    @UpdateProvider(type= HandsUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HandsUser record);

    @Update({
        "update handsuser",
        "set hands_password = #{handsPassword,jdbcType=VARCHAR},",
          "fakename = #{fakename,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=BIT},",
          "birthday = #{birthday,jdbcType=DATE},",
          "headImg = #{headimg,jdbcType=VARCHAR},",
          "money = #{money,jdbcType=DOUBLE},",
          "phone = #{phone,jdbcType=VARCHAR}",
        "where username = #{username,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(HandsUser record);
}