package com.matthew.springbootgradle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matthewlqm
 */
@SpringBootApplication
@MapperScan("com.matthew.springbootgradle.dal.mybatis")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

