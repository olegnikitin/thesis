package com.edu.thesis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oleg on 11.05.2015.
 */
@Controller

public class RestApiPageController {

    @RequestMapping("/rest/info")
    public ModelAndView getToRestApiPage(){
        ModelAndView mv = new ModelAndView("API");
        return mv;
    }

}
