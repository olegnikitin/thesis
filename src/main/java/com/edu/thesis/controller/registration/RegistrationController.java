package com.edu.thesis.controller.registration;

import com.edu.thesis.domain.User;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMethodRegistration(Model model){
        model.addAttribute(new User());
        return "registration/registration";
    }

    @RequestMapping(method = RequestMethod.POST)//TODO: Write it
    public String addUserFromForm(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registration";
        }
        userService.createUser(user);
        return "redirect:/users/edit_user=" + user.getLogin();//after registration - edit it
    }
}