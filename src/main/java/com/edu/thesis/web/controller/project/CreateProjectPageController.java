package com.edu.thesis.web.controller.project;

import com.edu.thesis.domain.Project;
import com.edu.thesis.service.projectService.ProjectService;
import com.edu.thesis.service.userService.UserService;
import com.edu.thesis.web.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Oleg on 19.01.2015.
 */
@Controller
@RequestMapping("/my/projects/create")
public class CreateProjectPageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getToCreateProjectPageMethod(Map<String, Object> map){
        map.put("project", new Project());
        map.put("userList", userService.listOfUsers());
        return "project/create_project";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProjectMethod(@Valid Project project, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "project/create_project";
        }
        projectService.createProject(project);
        return "redirect:/my/projects/" + project.getId() + "/edit";
    }

}
