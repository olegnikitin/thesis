package com.edu.thesis.web.controller;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.Project;
import com.edu.thesis.domain.User;
import com.edu.thesis.service.issueService.IssueService;
import com.edu.thesis.service.projectService.ProjectService;
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
    private IssueService issueService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getToUserPage(){
        ModelAndView mv = new ModelAndView("user_page");
        User currentUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        log.info(currentUser + " has gone to his own page");

        mv.addObject("issue", new Issue());
        mv.addObject("userIssues", issueService.listOfIssuesOfUser(currentUser.getId()));
        log.info("There are such tasks as " + issueService.listOfIssuesOfUser
                (currentUser.getId()) + " on the page");

        mv.addObject("project", new Project());
        mv.addObject("userProjects", projectService.listOfProjectsByUser(currentUser.getId()));
        log.info("There are such tasks as " + projectService
                .listOfProjectsByUser(currentUser.getId()) + " on the page");

        return mv;
    }

}
