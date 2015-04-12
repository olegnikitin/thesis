package com.edu.thesis.web.rest;

import com.edu.thesis.domain.Project;
import com.edu.thesis.service.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Oleg on 12.04.2015.
 */
@RestController
@RequestMapping("/rest/projects")
public class ProjectRestApi { //Just for fun

    private static final Logger log = Logger.getLogger(ProjectRestApi.class.getName());

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Project>> listOfProjects(){
        return new ResponseEntity<List<Project>>(projectService.listOfProjects(), HttpStatus.OK);//TODO: Resolve an exception
    }

}
