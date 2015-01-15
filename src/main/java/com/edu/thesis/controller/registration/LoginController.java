package com.edu.thesis.controller.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Oleg on 15.01.2015.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET) //TODO: Check if the service need
    public String loginMethod(){
        return "registration/login";
    }

}
