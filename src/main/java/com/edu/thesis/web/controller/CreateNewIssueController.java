package com.edu.thesis.web.controller;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.service.issueService.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Oleg on 16.01.2015.
 */
@Controller
@RequestMapping(value = "/create_issue")
public class CreateNewIssueController {

    @Autowired
    private IssueService issueService;

    @RequestMapping(method = RequestMethod.GET)
    public String goToCreateNewIssuePage(Model model){
        model.addAttribute(new Issue());
        return "create_issue";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createNewIssuePostMethod(@ModelAttribute Issue issue, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create_issue";
        }
        issueService.createIssue(issue);
        return "edit_issue=" + issue.getId();
    }

}
