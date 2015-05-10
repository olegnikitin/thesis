package com.edu.thesis.web.controller;

import com.edu.thesis.domain.User;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.logging.Logger;

/**
 * Created by Oleg on 18.01.2015.
 */
@Controller
@RequestMapping("my/users/{id}/edit")
public class EditUserController {

    private static final Logger log = Logger.getLogger(EditUserController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getToEditUserPage(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("edit_user");
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        log.info(user + " is being editing");
        if(user.getId() != id){
            return new ModelAndView("errorPages/403");
        }
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editUserPostMethod(@Valid @ModelAttribute User user, @PathVariable Long id, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("edit_user");
        }
        User currentUser = userService.getUser(id);
        user.setLogin(currentUser.getLogin());
        user.setDateOfRegistration(currentUser.getDateOfRegistration());
        //user.setTasks(currentUser.getTasks());
        user.setRolesOfTheUser(currentUser.getRolesOfTheUser());
        userService.updateUser(user);
        log.info(user + " was edited");
        return new ModelAndView("redirect:/my/users/" + currentUser.getId() + "/edit");
    }

}
