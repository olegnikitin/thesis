package com.edu.thesis.web.controller.project;

import com.edu.thesis.service.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oleg on 28.03.2015.
 */
@Controller
public class ListOfProjectsController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "my/projects", method = RequestMethod.GET)
    public ModelAndView getToListOfProjectsMethod(){
        ModelAndView mv = new ModelAndView("project/list_of_projects");
        mv.addObject("projectsList", projectService.listOfProjects());
        return mv;
    }
}
