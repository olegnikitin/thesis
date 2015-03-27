package com.edu.thesis.web.controller;

import com.edu.thesis.domain.User;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Oleg on 18.01.2015.
 */
@Controller
public class EditUserController {

    private Date date = null;
    private String login = null;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/edit_user={id}", method = RequestMethod.GET)//TODO: Unsecure. Check another way
    public String getToEditUserPage(@PathVariable("id") Long id, Model model){
        if(userService.getUser(id) == null){
            return "errorPages/403";
        }
        User user = userService.getUser(id);
        date = user.getDateOfRegistration();
        login = user.getLogin();
        model.addAttribute(user);
        return "edit_user";
    }

    @RequestMapping(value = "/users/edit_user={id}", method = RequestMethod.POST)
    public String editUserPostMethod(@Valid @ModelAttribute User user, @PathVariable("id") Long id, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit_user";
        }
        user.setDateOfRegistration(date);
        user.setLogin(login);
        userService.updateUser(user);
        return "edit_user";
    }

}
