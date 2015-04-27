package com.edu.thesis.web.rest;

import com.edu.thesis.domain.Project;
import com.edu.thesis.service.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Oleg on 12.04.2015.
 */
@RestController
public class ProjectRestApi { //Just for fun

    private static final Logger log = Logger.getLogger(ProjectRestApi.class.getName());

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/rest/projects", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Project>> listOfProjects(){
        List<Project> listOfProjects = projectService.listOfProjects();
        HttpStatus status = listOfProjects != null ?
                HttpStatus.OK : HttpStatus.NOT_FOUND;
        log.info("Getting list of projects is " + status);
        return new ResponseEntity<>(listOfProjects, status);
    }

    @RequestMapping(value = "/rest/projects/create", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ResponseEntity createProject(@RequestBody Project project) {
        projectService.createProject(project);
        log.info("Project was created");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value="/rest/projects/{id}", method = RequestMethod.GET)
    public ResponseEntity<Project> getProjectById(@PathVariable long id) {
        Project project = projectService.getProject(id);
        HttpStatus status = project != null ?
                HttpStatus.OK : HttpStatus.NOT_FOUND;
        log.info("Getting project is " + status);
        return new ResponseEntity<>(project, status);
    }

    @RequestMapping(value="/rest/projects/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Project> updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
        log.info("Project was updated");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/rest/projects/{id}/delete", method= RequestMethod.DELETE)
    public ResponseEntity deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        log.info("Project was deleted");
        return new ResponseEntity(HttpStatus.OK);
    }

}
