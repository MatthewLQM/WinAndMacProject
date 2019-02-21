package com.matthew.springbootgradle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zeyuan
 * Create Time : 2019/2/20 5:58 PM
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

}
