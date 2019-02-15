package com.matthew.springbootgradle.service.impl;

import com.matthew.springbootgradle.dal.jdbc.TestJdbcRepository;
import com.matthew.springbootgradle.dal.model.Test;
import com.matthew.springbootgradle.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zeyuan
 * Create Time : 2019/2/15 11:27 PM
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestJdbcRepository testJdbcRepository;

    @Override
    public List<Test> queryAllTest() {
        return testJdbcRepository.queryAllTest();
    }

    @Override
    public Test queryByName(String name) {
        return testJdbcRepository.queryTestByName(name);
    }
}
