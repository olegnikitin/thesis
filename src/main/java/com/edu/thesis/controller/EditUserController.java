package com.edu.thesis.controller;

import com.edu.thesis.domain.User;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Oleg on 18.01.2015.
 */
@Controller
public class EditUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/edit_user={userName}", method = RequestMethod.GET)//TODO: Unsecure. Check another way
    public String getToEditUserPage(@PathVariable("userName") String userName, Model model){
        if(userService.getUser(userName) == null){
            return "errorPages/403";
        }
        model.addAttribute(userService.getUser(userName));
        return "edit_user";
    }

    @RequestMapping(value = "/users/edit_user={userName}", method = RequestMethod.POST)
    public String editUserPostMethod(@Valid User user, @PathVariable("userName") String userName, //String is only for URI
                                     BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit_user";
        }
        userService.updateUser(user);
        return "edit_user";
    }

}
