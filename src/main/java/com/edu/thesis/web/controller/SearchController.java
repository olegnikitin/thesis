package com.edu.thesis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oleg on 02.04.2015.
 */
@Controller
public class SearchController {

    /*@Autowired
    private ElasticsearchIssueDao elasticsearchIssueDao;*/

    @RequestMapping(value = "/searchedIssues={issue}", method = RequestMethod.GET)
    public ModelAndView searchIssues(@PathVariable String issue){
        ModelAndView mv = new ModelAndView("searchPages/searched_issues");

        return mv;
    }

}
