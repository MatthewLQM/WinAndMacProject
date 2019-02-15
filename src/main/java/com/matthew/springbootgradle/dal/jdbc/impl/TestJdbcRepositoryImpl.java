package com.matthew.springbootgradle.dal.jdbc.impl;

import com.matthew.springbootgradle.dal.jdbc.TestJdbcRepository;
import com.matthew.springbootgradle.dal.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zeyuan
 * Create Time : 2019/2/15 11:31 PM
 */
@Service
public class TestJdbcRepositoryImpl implements TestJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Test> queryAllTest() {
        String sql = "SELECT * FROM test_table";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Test test = new Test();
            test.setId(resultSet.getLong("id"));
            test.setName(resultSet.getString("name"));
            return test;
        });
    }

    @Override
    public Test queryTestByName(String name) {
        String sql = "SELECT * FROM test_table WHERE name = \'" + name + '\'';
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
            Test test = new Test();
            test.setId(resultSet.getLong("id"));
            test.setName(resultSet.getString("name"));
            return test;
        });
    }
}
