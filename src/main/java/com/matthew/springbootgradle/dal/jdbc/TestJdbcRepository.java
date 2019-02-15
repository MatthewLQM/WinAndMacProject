package com.matthew.springbootgradle.dal.jdbc;

import com.matthew.springbootgradle.dal.model.Test;

import java.util.List;

/**
 * @author zeyuan
 * Create Time : 2019/2/15 11:30 PM
 */
public interface TestJdbcRepository {

    List<Test> queryAllTest();

    Test queryTestByName(String name);

}
