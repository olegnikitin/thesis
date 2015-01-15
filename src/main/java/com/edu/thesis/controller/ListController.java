package com.edu.thesis.controller;

import com.edu.thesis.domain.Test;
import com.edu.thesis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Oleg on 13.01.2015.
 */
@Controller
public class ListController {

    @Autowired
    private TestService testService;

    @RequestMapping("/list_of_tests")
    public String listOfTests(Map<String, Object> map){
        map.put("test", new Test());
        map.put("testList", testService.listOfTests());
        return "list_of_goods";
    }

    @RequestMapping("delete_test={id}")
    public String deleteGoods(@PathVariable("id") Long id) {
        testService.removeTest(id);
        return "redirect:/list_of_tests";
    }

}
