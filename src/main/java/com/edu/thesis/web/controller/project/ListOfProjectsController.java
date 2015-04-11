package com.edu.thesis.web.controller.project;

import com.edu.thesis.domain.Project;
import com.edu.thesis.service.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/admin/projects/", method = RequestMethod.GET)
    public ModelAndView getToListOfProjectsMethod(){
        ModelAndView mv = new ModelAndView("project/list_of_projects");
        mv.addObject("project", new Project());
        mv.addObject("projectsList", projectService.listOfProjects());
        return mv;
    }

    @RequestMapping(value = "/my/projects/{id}/delete", method = RequestMethod.GET)
    public String deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return "redirect:/admin/projects/";
    }

}
