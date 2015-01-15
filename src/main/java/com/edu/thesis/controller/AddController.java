package com.edu.thesis.controller;

import com.edu.thesis.domain.Test;
import com.edu.thesis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Oleg on 12.01.2015.
 */
@Controller
public class AddController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test_add", method = RequestMethod.GET)
    public String goToAddPage(Model model){
        model.addAttribute(new Test());
        return "test_add";
    }

    @RequestMapping(value = "/test_add", method = RequestMethod.POST)
    public String addTest(Test test, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "error";
        }
        testService.addTest(test);
        return "test_add";
    }

}
