package com.muc.mapper;

import com.muc.bean.Transactions;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface TransactionsMapper {
    @Delete({
        "delete from transactions",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into transactions (id, inuid, ",
        "outuid, transaction_amount, ",
        "ttime)",
        "values (#{id,jdbcType=INTEGER}, #{inuid,jdbcType=VARCHAR}, ",
        "#{outuid,jdbcType=VARCHAR}, #{transactionAmount,jdbcType=DOUBLE}, ",
        "#{ttime,jdbcType=TIMESTAMP})"
    })
    int insert(Transactions record);

    @InsertProvider(type= TransactionsSqlProvider.class, method="insertSelective")
    int insertSelective(Transactions record);

    @Select({
        "select",
        "id, inuid, outuid, transaction_amount, ttime",
        "from transactions",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="inuid", property="inuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="outuid", property="outuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="transaction_amount", property="transactionAmount", jdbcType=JdbcType.DOUBLE),
        @Result(column="ttime", property="ttime", jdbcType=JdbcType.TIMESTAMP)
    })
    Transactions selectByPrimaryKey(Integer id);

    @UpdateProvider(type= TransactionsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Transactions record);

    @Update({
        "update transactions",
        "set inuid = #{inuid,jdbcType=VARCHAR},",
          "outuid = #{outuid,jdbcType=VARCHAR},",
          "transaction_amount = #{transactionAmount,jdbcType=DOUBLE},",
          "ttime = #{ttime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Transactions record);
}