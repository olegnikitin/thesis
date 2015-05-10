package com.edu.thesis.web.controller.project;

import com.edu.thesis.domain.Project;
import com.edu.thesis.domain.User;
import com.edu.thesis.service.projectService.ProjectService;
import com.edu.thesis.service.userService.UserService;
import com.edu.thesis.web.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Oleg on 19.01.2015.
 */
@Controller
@RequestMapping("/my/projects/create")
public class CreateProjectPageController {

    private static final Logger log = Logger.getLogger(CreateProjectPageController.class.getName());

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getToCreateProjectPageMethod(Map<String, Object> map){
        map.put("dto", new ProjectDto());
        map.put("user", new User());
        map.put("userList", userService.listOfUsers());
        return "project/create_project";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProjectMethod(@ModelAttribute(value = "dto") @Valid ProjectDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "project/create_project";
        }
        Project project = new Project();
        project.setNameOfTheProject(dto.getNameOfTheProject());
        project.setDescriptionOfTheProject(dto.getDescriptionOfTheProject());
        project.setLeadOfTheProject(userService.getUser(dto.getLeadOfTheProject()));
        projectService.createProject(project);
        log.info(project + " was created");
        return "redirect:/my/projects/" + project.getId() + "/update";
    }

}
