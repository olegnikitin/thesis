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
import java.util.logging.Logger;

/**
 * Created by Oleg on 16.01.2015.
 */
@Controller
@RequestMapping
public class ListOfIssuesPageController {

    private static final Logger log = Logger.getLogger(ListOfIssuesPageController.class.getName());

    @Autowired
    private IssueService issueService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/my/projects/{pr_id}/issues", method = RequestMethod.GET)
    public ModelAndView getMethodToGetListOfBugsPage(@PathVariable("pr_id") Long id){
        Project project = projectService.getProject(id);
        log.info("the project is " + project);
        ModelAndView mv = null;
        if(!(project == null)){
            mv = new ModelAndView("issue/list_of_issues");
            mv.addObject("issue", new Issue());
            mv.addObject("issueList", project.getIssues());
            mv.addObject("project_id", project.getId());
        }else mv = new ModelAndView("errorPages/404");
        return mv;
    }

    @RequestMapping("/my/projects/{project_id}/issues/{issue_id}/delete")
    public String deleteIssue(@PathVariable Long project_id, @PathVariable Long issue_id){
        issueService.removeIssue(issue_id);
        log.info("issue #" + issue_id + " was deleted");
        return "redirect:/my/projects/" + project_id + "/issues";
    }

}
