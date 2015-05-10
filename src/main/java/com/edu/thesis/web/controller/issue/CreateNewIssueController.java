package com.edu.thesis.web.controller.issue;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.enums.PriorityOfTheTask;
import com.edu.thesis.domain.enums.StatusOfTheTask;
import com.edu.thesis.domain.enums.TypeOfTheTask;
import com.edu.thesis.service.issueService.IssueService;
import com.edu.thesis.service.projectService.ProjectService;
import com.edu.thesis.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Oleg on 16.01.2015.
 */
@Controller
@RequestMapping(value = "/my/projects/{pr_id}/issues/create")
public class CreateNewIssueController {

    private static final Logger log = Logger.getLogger(CreateNewIssueController.class.getName());

    @Autowired
    private IssueService issueService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView goToCreateNewIssuePage(){
        ModelAndView mv = new ModelAndView("issue/create_issue");
        mv.addObject("issue", new Issue());
        mv.addObject("listOfPriorities", new ArrayList<PriorityOfTheTask>(Arrays.asList(PriorityOfTheTask.values())));
        mv.addObject("listOfTypes", new ArrayList<TypeOfTheTask>(Arrays.asList(TypeOfTheTask.values())));
        mv.addObject("listOfStatuses", new ArrayList<StatusOfTheTask>(Arrays.asList(StatusOfTheTask.values())));
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createNewIssuePostMethod(@PathVariable("pr_id") Long pr_id,
                                           @ModelAttribute @Valid Issue issue, BindingResult bindingResult,
                                           @RequestParam(value="file_of_issue", required=false)
                                           MultipartFile file){
        ModelAndView mv;
        if(bindingResult.hasErrors()){
            mv = new ModelAndView("errorPages/404");
            return mv;
        }
        //Adding new file to the system and to this issue
        if(!file.isEmpty()){
            //TODO: Add a file to the server, put the path to StoragedFile, add the StFile to the issue
        }

        //Adding the settings of the issue
        issue.setProjectOfTheIssue(projectService.getProject(pr_id));
        issue.setDateOfModification(new Date());
        issue.setOwnerOfTheTask(userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()));
        issueService.createIssue(issue);
        log.info(issue + " was created");
        mv = new ModelAndView("redirect:/my/projects/" + pr_id + "/issues/" + issue.getId() + "/update");
        return mv;
    }

    private void validateFile(MultipartFile file) {
        /*if(!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accepted");
        }*/
    }

    /*private void saveFile(String filename, MultipartFile image){
        try {
            File file = new File(webRootPath() + "/resources/" + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());//Apache Commons IO //TODO: Download it
        } catch (IOException e) {
            log.warning(e.toString());
        }
    }*/

    private String webRootPath(){
        //TODO: Check the path and return it to method
        return null;
    }

}
