package com.edu.thesis.web.controller.issue;

import com.edu.thesis.domain.Issue;
import com.edu.thesis.domain.enums.PriorityOfTheTask;
import com.edu.thesis.domain.enums.StatusOfTheTask;
import com.edu.thesis.domain.enums.TypeOfTheTask;
import com.edu.thesis.service.issueService.IssueService;
import com.edu.thesis.service.projectService.ProjectService;
import com.edu.thesis.service.userService.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.filechooser.FileSystemView;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
        mv.addObject("listOfPriorities", new ArrayList<>(Arrays.asList(PriorityOfTheTask.values())));
        mv.addObject("listOfTypes", new ArrayList<>(Arrays.asList(TypeOfTheTask.values())));
        mv.addObject("listOfStatuses", new ArrayList<>(Arrays.asList(StatusOfTheTask.values())));
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

    private void validateFile(MultipartFile file) throws Exception {
        if(!file.getContentType().equals("image/jpeg")){
            throw new Exception("Only JPG images accepted");//TODO: Add new exception for uploaded files
        }
    }

    private void saveFile(String filename, MultipartFile file){
        try {
            File writtenFile = new File(webRootPath() + "/resources/" + filename);//May be the problem with dir creation
            //File file = new File("/resources/" + filename);
            FileUtils.writeByteArrayToFile(writtenFile, file.getBytes());
        } catch (IOException e) {
            log.warning(e.toString());
        }
    }

    /**
     * Checking the path and return it to method
     * @return rootPath
     */
    private String webRootPath(){//TODO: Upload it to the resources
        //FileSystemView is from swing directory. Check another wat
        return FileSystemView.getFileSystemView().getDefaultDirectory().getAbsolutePath();//Will it work?
    }

}
