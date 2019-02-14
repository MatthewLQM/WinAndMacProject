package com.matthew.springbootgradle.hello;

import com.matthew.springbootgradle.dal.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author matthewlqm
 * Create Time : 2019/2/1 3:30 PM
 */
@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @RequestMapping("/query")
    public String query() {
        String sql = "SELECT * FROM test_table";
        List<Test> tests = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Test test = new Test();
            test.setId(resultSet.getLong("id"));
            test.setName(resultSet.getString("name"));
            return test;
        });
        if(tests.isEmpty()) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        tests.forEach(test -> result.append(test).append(";"));
        return result.toString();
    }
}
