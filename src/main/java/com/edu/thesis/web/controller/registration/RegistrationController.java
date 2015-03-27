package com.edu.thesis.web.controller.registration;

import com.edu.thesis.domain.User;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Oleg on 15.01.2015.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMethodRegistration(){
        ModelAndView mv = new ModelAndView("registration/registration");
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)//TODO: Write it
    public String addUserFromForm(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registration";
        }
        user.setDateOfRegistration(new Date());
        try{
            userService.createUser(user);//TODO: Catch a ERROR SqlExceptionHelper. Very important
        }catch (Exception e){
            e.printStackTrace();
            return "registration/registration";
        }
        return "redirect:/users/edit_user=" + user.getId();
    }
}