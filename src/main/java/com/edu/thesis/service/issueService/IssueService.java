package com.edu.thesis.service.issueService;

import com.edu.thesis.domain.Issue;

import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
public interface IssueService {
    public List<Issue> listOfIssues();
    public List<Issue> listOfIssuesOfProject(Long id);
    public List<Issue> listOfIssuesOfUser(Long id);
    public Issue getIssue(Long id);
    public void createIssue(Issue issue);
    public void updateIssue(Issue issue);
    public void removeIssue(Long id);
}
