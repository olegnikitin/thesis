package com.edu.thesis.web.controller.registration;

import com.edu.thesis.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Oleg on 15.01.2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String loginGetMethod(Model model){
        model.addAttribute(new User());
        return "registration/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginPostMethod(@Valid User user, BindingResult bindingResult){//TODO: Get a user from base
        if(bindingResult.hasErrors()){
            return "registration/login";
        }
        return "/home";
    }

}
