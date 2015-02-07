package com.edu.thesis.web.controller.issue;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.enums.PriorityOfTheTask;
import com.edu.thesis.domain.enums.StatusOfTheTask;
import com.edu.thesis.domain.enums.TypeOfTheTask;
import com.edu.thesis.service.issueService.IssueService;
import com.edu.thesis.service.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by Oleg on 16.01.2015.
 */
@Controller
@RequestMapping(value = "projects/project={pr_id}/issues/create")
public class CreateNewIssueController {

    @Autowired
    private IssueService issueService;

    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String goToCreateNewIssuePage(Map<String, Object> map){
        map.put("issue", new Issue());
        map.put("listOfPriorities", new ArrayList<PriorityOfTheTask>(Arrays.asList(PriorityOfTheTask.values())));
        map.put("listOfTypes", new ArrayList<TypeOfTheTask>(Arrays.asList(TypeOfTheTask.values())));
        map.put("listOfStatuses", new ArrayList<StatusOfTheTask>(Arrays.asList(StatusOfTheTask.values())));
        return "issue/create_issue";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createNewIssuePostMethod(@PathVariable("pr_id") Long pr_id,
                                           @ModelAttribute @Valid Issue issue, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "issue/create_issue";
        }
        //issue.setProjectOfTheIssue(projectService.getProject(pr_id));//TODO:Check whit it isn't works
        Date date = new Date();
        issue.setDateOfCreation(date);
        issue.setDateOfModification(date);
        //System.out.println(issue);
        issueService.createIssue(issue);
        return "redirect:/projects/project=" + pr_id + "/issues/edit=" + issue.getId();
    }

}