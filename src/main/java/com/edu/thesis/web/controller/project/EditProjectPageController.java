package com.edu.thesis.web.controller.project;

import com.edu.thesis.service.projectService.ProjectService;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Oleg on 06.02.2015.
 */
@Controller
public class EditProjectPageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "projects/edit={id}", method = RequestMethod.GET)
    public String getToCreateProjectPageMethod(Map<String, Object> map, @PathVariable("id") Long id){
        return "";
    }



}
