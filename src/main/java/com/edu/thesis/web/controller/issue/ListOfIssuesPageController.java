package com.edu.thesis.web.controller.issue;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.service.issueService.IssueService;
import com.edu.thesis.service.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Oleg on 16.01.2015.
 */
@Controller
public class ListOfIssuesPageController {

    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "projects/project={pr_id}/issues", method = RequestMethod.GET)//TODO: Write final code for view
    public ModelAndView getMethodToGetListOfBugsPage(){
        ModelAndView mv = new ModelAndView("issue/list_of_issues");
        mv.addObject("issue", new Issue());
        mv.addObject("issueList", issueService.listOfIssues());
        return mv;
    }

}
