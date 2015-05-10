package com.edu.thesis.web.controller;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.Project;
import com.edu.thesis.domain.User;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by Oleg on 11.04.2015.
 */
@Controller
@RequestMapping("/my/")
public class UserPageController {

    private static final Logger log = Logger.getLogger(UserPageController.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getToUserPage(){
        ModelAndView mv = new ModelAndView("user_page");
        User currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        log.info(currentUser + " has gone to his own page");
        mv.addObject("issue", new Issue());
        /*mv.addObject("userIssues", currentUser.getTasks());
        log.info("There are such tasks as " + currentUser.getTasks() + " on the page");*/
        mv.addObject("project", new Project());
        //mv.addObject("userProjects", this.setOfUserProjects(currentUser));
        return mv;
    }

    /**
     * @param user
     * @return set of projects where user takes part
     */
    /*private Set<Project> setOfUserProjects(User user){
        Set<Project> projects = null;
        for(Issue issue : user.getTasks()){
            projects.add(issue.getProjectOfTheIssue());
        }
        log.info("There are such projects as " + projects + " on the page");
        return projects;
    }*/

}
