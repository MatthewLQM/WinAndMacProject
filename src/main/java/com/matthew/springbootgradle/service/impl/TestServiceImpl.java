package com.matthew.springbootgradle.service.impl;

import com.matthew.springbootgradle.dal.jdbc.TestJdbcRepository;
import com.matthew.springbootgradle.dal.model.Test;
import com.matthew.springbootgradle.dal.mybatis.TestMyBatisRepository;
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

    @Autowired
    private TestMyBatisRepository testMyBatisRepository;

    @Override
    public List<Test> queryAllTest() {
        //return testJdbcRepository.queryAllTest();
        return testMyBatisRepository.selectAll();
    }

    @Override
    public Test queryByName(String name) {
        return testJdbcRepository.queryTestByName(name);
    }

    @Override
    public void insertTest(Long id, String name) {
        testJdbcRepository.insertTest(id, name);
    }

    @Override
    public void deleteTest(Long id) {
        testJdbcRepository.deleteTest(id);
    }
}
