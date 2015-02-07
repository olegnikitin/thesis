package com.edu.thesis.web.controller.project;

import com.edu.thesis.domain.Project;
import com.edu.thesis.service.projectService.ProjectService;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Oleg on 06.02.2015.
 */
@Controller
@RequestMapping(value = "projects/edit={id}")
public class EditProjectPageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getToCreateProjectPageMethod(Map<String, Object> map, @PathVariable("id") Long id){
        Project project = projectService.getProject(id);
        map.put("project", project);
        map.put("userList", userService.listOfUsers());//TODO:Find a way to edit it
        map.put("issueList", project.getIssues());
        return "project/edit_project";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProjectMethod(@Valid Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "project/edit_project";
        }
        projectService.updateProject(project);
        return "project/edit_project=" + project.getId();
    }

}
