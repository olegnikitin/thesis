package com.edu.thesis.web.controller.issue;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.enums.PriorityOfTheTask;
import com.edu.thesis.domain.enums.StatusOfTheTask;
import com.edu.thesis.domain.enums.TypeOfTheTask;
import com.edu.thesis.service.issueService.IssueService;
import com.edu.thesis.service.projectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Oleg on 07.02.2015.
 */
@Controller
@RequestMapping(value = "/my/projects/{pr_id}/issues/{is_id}/update")
public class EditIssueController {

    private static final Logger log = Logger.getLogger(EditIssueController.class.getName());

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IssueService issueService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getToEditIssuePageController(@PathVariable("pr_id") Long pr_id,
                                                     @PathVariable("is_id") Long is_id){
        if(projectService.getProject(pr_id).equals(null)){//check of existing project
            return new ModelAndView("errorPages/404");
        }
        ModelAndView mv = new ModelAndView("issue/edit_issue");
        mv.addObject("issue", issueService.getIssue(is_id));
        mv.addObject("listOfPriorities", new ArrayList<PriorityOfTheTask>(Arrays.asList(PriorityOfTheTask.values())));
        mv.addObject("listOfTypes", new ArrayList<TypeOfTheTask>(Arrays.asList(TypeOfTheTask.values())));
        mv.addObject("listOfStatuses", new ArrayList<StatusOfTheTask>(Arrays.asList(StatusOfTheTask.values())));
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editIssueMethod(@ModelAttribute @Valid Issue issue, @PathVariable("pr_id") Long pr_id,
                                  @PathVariable("is_id") Long is_id, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.warning("error while editing");
            return "issue/edit_issue";
        }
        issue.setDateOfModification(new Date());
        //TODO: Add a field to change the owner
        issueService.updateIssue(issue);//TODO: Check it. Wasn't tested
        log.info(issue + " was edited");
        return "redirect:/my/projects/" + pr_id + "/issues/" + is_id + "/update";
    }
}
