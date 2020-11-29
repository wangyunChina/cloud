package com.muc.mapper;

import com.muc.bean.Book;
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

public interface BookMapper {
    @Delete({
        "delete from book",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into book (id, title, ",
        "total, descs, src)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{total,jdbcType=INTEGER}, #{descs,jdbcType=VARCHAR}, #{src,jdbcType=VARCHAR})"
    })
    int insert(Book record);

    @InsertProvider(type=BookSqlProvider.class, method="insertSelective")
    int insertSelective(Book record);

    @Select({
        "select",
        "id, title, total, descs, src",
        "from book",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
        @Result(column="descs", property="descs", jdbcType=JdbcType.VARCHAR),
        @Result(column="src", property="src", jdbcType=JdbcType.VARCHAR)
    })
    Book selectByPrimaryKey(Integer id);
    @Select({
            "select",
            "id, title, total, descs, src",
            "from book",

    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
            @Result(column="descs", property="descs", jdbcType=JdbcType.VARCHAR),
            @Result(column="src", property="src", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<Book> selectAll();

    @UpdateProvider(type=BookSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Book record);

    @Update({
        "update book",
        "set title = #{title,jdbcType=VARCHAR},",
          "total = #{total,jdbcType=INTEGER},",
          "descs = #{descs,jdbcType=VARCHAR},",
          "src = #{src,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Book record);
}