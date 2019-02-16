package com.matthew.springbootgradle.hello;

import com.matthew.springbootgradle.dal.model.Test;
import com.matthew.springbootgradle.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/index")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private TestService testService;

    @RequestMapping
    public String index(Model model) {
        LOGGER.info("method=index，request=" + model);
        List<Test> tests = testService.queryAllTest();
        model.addAttribute("tests", tests);
        model.addAttribute("test", new Test());
        model.addAttribute("action", "create");
        return "index";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute Test test) {
        LOGGER.info("method=create，request=" + test);
        testService.insertTest(test.getId(), test.getName());
        return "redirect:/index/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        LOGGER.info("method=delete，request=" + id);
        testService.deleteTest(id);
        return "redirect:/index/";
    }

}
