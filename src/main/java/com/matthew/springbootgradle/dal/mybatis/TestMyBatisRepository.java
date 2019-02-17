package com.matthew.springbootgradle.dal.mybatis;

import com.matthew.springbootgradle.dal.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMyBatisRepository {

    @Select("SELECT * FROM test_table")
    List<Test> selectAll();

    @Select("SELECT * FROM test_table WHERE id = #{id}")
    Test selectById(@Param("id") Long id);

}
