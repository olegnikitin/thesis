package com.edu.thesis.web.controller.project;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.Project;
import com.edu.thesis.domain.User;
import com.edu.thesis.service.projectService.ProjectService;
import com.edu.thesis.service.userService.UserService;
import com.edu.thesis.web.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Oleg on 06.02.2015.
 */
@Controller
@RequestMapping(value = "/my/projects/{id}/edit")
public class EditProjectPageController {

    private static final Logger log = Logger.getLogger(EditProjectPageController.class.getName());

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getToCreateProjectPageMethod(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("project/edit_project");
        Project project = projectService.getProject(id);
        if(project == null){
            mav = new ModelAndView("errorPages/404");
            log.warning("There is no such project with id " + id);
        }
        ProjectDto dto = this.toDTO(project);
        mav.addObject("dto", dto);
        mav.addObject("projectUserList", project.getUsersInTheCurrentProject());
        mav.addObject("userList", userService.listOfUsers());
        mav.addObject("issueList", project.getIssues());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createProjectMethod(@Valid @ModelAttribute("dto") ProjectDto dto, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("project/edit_project");
        if (bindingResult.hasErrors()) {
            return mav;
        }
        Project project = this.fromDto(dto);
        projectService.updateProject(project);
        return mav;
    }

    /**
     * Converting Project to DTO
     * @param project
     * @return DTO
     */
    private ProjectDto toDTO(Project project){
        ProjectDto dto = new ProjectDto();
        dto.setId(project.getId());
        dto.setNameOfTheProject(project.getNameOfTheProject());
        dto.setDescriptionOfTheProject(project.getDescriptionOfTheProject());
        dto.setLeadOfTheProject(project.getLeadOfTheProject().getId());

        Iterator iterator = null;
        int i = 0;

        //Get long[] ids from project.getIssues and setting to dto
        long[] issuesId = new long[project.getIssues().size()];
        iterator = project.getIssues().iterator();
        while (i != project.getIssues().size()){
            issuesId[i] = ((Issue)iterator.next()).getId();
            i++;
        }
        dto.setIssues(issuesId);

        iterator = null; i = 0;//Setting to null

        //Get long[] ids from project.getUsersInTheCurrentProject and setting to dto
        long[] usersId = new long[project.getUsersInTheCurrentProject().size()];
        iterator = project.getUsersInTheCurrentProject().iterator();
        while ( i != project.getUsersInTheCurrentProject().size()){
            usersId[i] = ((User)iterator.next()).getId();
            i++;
        }
        dto.setUsersInTheCurrentProject(usersId);

        return dto;
    }

    /**
     * Converting from DTO to Project
     * @param dto
     * @return Project
     */
    private Project fromDto(ProjectDto dto){
        Project project = projectService.getProject(dto.getId());

        return project;
    }
}
