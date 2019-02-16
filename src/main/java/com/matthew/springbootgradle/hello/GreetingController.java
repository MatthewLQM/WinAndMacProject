package com.matthew.springbootgradle.hello;

import com.matthew.springbootgradle.dal.model.Test;
import com.matthew.springbootgradle.service.TestService;
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

    @Autowired
    private TestService testService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @RequestMapping("/query")
    public String query() {
        List<Test> tests = testService.queryAllTest();
        if(tests.isEmpty()) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        tests.forEach(test -> result.append(test).append(";"));
        return result.toString();
    }

    @RequestMapping("/condition")
    public String condition(@RequestParam(value = "name", defaultValue = "zeyuan") String name) {
        Test test = testService.queryByName(name);
        return test.toString();
    }

    @RequestMapping("/insert")
    public String insert(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name){
        if(id == null || name == null) {
            return "输入参数 id 和 name 不能为 null";
        }
        testService.insertTest(id, name);
        return "true";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        testService.deleteTest(id);
        return "true";
    }
}
