package com.matthew.springbootgradle.dal.mapper;

import com.matthew.springbootgradle.dal.model.Test;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author zeyuan
 * Create Time : 2019/2/13 11:41 PM
 */
@Component
public interface TestTableMapper {

    @Select("SELECT * FROM test_table")
    Test selectAll();

}
