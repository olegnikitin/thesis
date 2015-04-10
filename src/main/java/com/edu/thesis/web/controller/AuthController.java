package com.edu.thesis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Oleg on 06.04.2015.
 */
@Controller
public class AuthController {

    @RequestMapping(value = "/auth/logout")
    public String auth(){
        return "redirect:/";
    }

}
