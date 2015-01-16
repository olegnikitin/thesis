package com.edu.thesis.controller;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.service.issueService.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Oleg on 16.01.2015.
 */
@Controller
public class ListOfBugsPageController {

    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "/list_of_bugs", method = RequestMethod.GET)
    public String getMethodToGetListOfBugsPage(Map<String, Object> map){
        map.put("issue", new Issue());
        map.put("issueList", issueService.listOfIssues());
        return "list_of_bugs";
    }

}
