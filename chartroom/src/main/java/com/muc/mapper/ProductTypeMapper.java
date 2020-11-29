package com.muc.mapper;

import com.muc.bean.ProductTypeKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface ProductTypeMapper {
    @Delete({
        "delete from product_type",
        "where pid = #{pid,jdbcType=INTEGER}",
          "and tid = #{tid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(ProductTypeKey key);

    @Insert({
        "insert into product_type (pid, tid)",
        "values (#{pid,jdbcType=INTEGER}, #{tid,jdbcType=INTEGER})"
    })
    int insert(ProductTypeKey record);

    @InsertProvider(type=ProductTypeSqlProvider.class, method="insertSelective")
    int insertSelective(ProductTypeKey record);
}