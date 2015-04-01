package com.edu.thesis.web.controller.project;

import com.edu.thesis.domain.Project;
import com.edu.thesis.domain.User;
import com.edu.thesis.service.projectService.ProjectService;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Oleg on 06.02.2015.
 */
@Controller
@RequestMapping(value = "my/projects/edit={id}") //TODO: Edit page to get to it. Isn't workable
public class EditProjectPageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getToCreateProjectPageMethod(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("project/edit_project");
        Project project = projectService.getProject(id);
        mav.addObject("project", project);
        mav.addObject("userList", userService.listOfUsers());
        mav.addObject("issueList", project.getIssues());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createProjectMethod(@Valid @ModelAttribute Project project, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("project/edit_project");
        if (bindingResult.hasErrors()) {
            return mav;
        }
        projectService.updateProject(project);
        return mav;
    }

}
