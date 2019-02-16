package com.matthew.springbootgradle.service;

import com.matthew.springbootgradle.dal.model.Test;

import java.util.List;

/**
 * @author zeyuan
 * Create Time : 2019/2/15 11:27 PM
 */
public interface TestService {

    List<Test> queryAllTest();

    Test queryByName(String name);

    void insertTest(Long id, String name);

    void deleteTest(Long id);
}
