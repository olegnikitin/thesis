package com.edu.thesis.web.controller.issue;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.enums.PriorityOfTheTask;
import com.edu.thesis.domain.enums.StatusOfTheTask;
import com.edu.thesis.domain.enums.TypeOfTheTask;
import com.edu.thesis.service.issueService.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * Created by Oleg on 07.02.2015.
 */
@Controller
@RequestMapping(value = "projects/project={pr_id}/issues/edit={is_id}")
public class EditIssueController {

    @Autowired
    private IssueService issueService;

    @RequestMapping(method = RequestMethod.GET)
    public String getToEditIssuePageController(@PathVariable("pr_id") Long pr_id, @PathVariable("is_id") Long is_id,
                                          Map<String, Object> map){
        map.put("issue", issueService.getIssue(is_id));
        map.put("listOfPriorities", new ArrayList<PriorityOfTheTask>(Arrays.asList(PriorityOfTheTask.values())));
        map.put("listOfTypes", new ArrayList<TypeOfTheTask>(Arrays.asList(TypeOfTheTask.values())));
        map.put("listOfStatuses", new ArrayList<StatusOfTheTask>(Arrays.asList(StatusOfTheTask.values())));
        return "issue/edit_issue";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editIssueMethod(@ModelAttribute @Valid Issue issue, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "issue/edit_issue";
        }
        issue.setDateOfModification(new Date());
        return "issue/edit_issue";
    }
}