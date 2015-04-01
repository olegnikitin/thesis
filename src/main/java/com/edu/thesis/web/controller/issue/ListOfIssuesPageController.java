package com.edu.thesis.web.controller.issue;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.Project;
import com.edu.thesis.service.issueService.IssueService;
import com.edu.thesis.service.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "my/projects/project={pr_id}/issues", method = RequestMethod.GET)
    public ModelAndView getMethodToGetListOfBugsPage(@PathVariable("pr_id") Long id){
        Project project = projectService.getProject(id);
        ModelAndView mv = null;
        if(!(project == null)){
            mv = new ModelAndView("issue/list_of_issues");
            mv.addObject("issue", new Issue());
            mv.addObject("issueList", project.getIssues());
        }else mv = new ModelAndView("errorPages/404");
        return mv;
    }

}
