package com.edu.thesis.web.controller.project;

import com.edu.thesis.domain.Issue;
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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Oleg on 19.01.2015.
 */
@Controller
@RequestMapping("projects/create")
public class CreateProjectPageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getToCreateProjectPageMethod(Map<String, Object> map){
        map.put("dto", new ProjectDto());
        map.put("userList", userService.listOfUsers());
        return "project/create_project";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProjectMethod(@Valid ProjectDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "project/create_project";
        }
        Project project = new Project();
        project.setNameOfTheProject(dto.getNameOfTheProject());
        project.setLeadOfTheProject(userService.getUser(dto.getLeadOfTheProject()));
        projectService.createProject(project);
        return "redirect:/projects/edit=" + project.getId();
    }

}
