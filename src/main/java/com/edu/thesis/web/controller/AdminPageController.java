package com.edu.thesis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oleg on 11.04.2015.
 */
@Controller
@RequestMapping("/admin/")
public class AdminPageController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView goToAdminPage(){
        ModelAndView mv = new ModelAndView("admin_page");
        return mv;
    }

}
