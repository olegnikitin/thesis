package com.edu.thesis.dao.issueDao;

import com.edu.thesis.domain.Issue;

import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
public interface IssueDao {
    public List<Issue> listOfIssues();
    public List<Issue> listOfIssuesOfProject(Long id);
    public List<Issue> listOfIssuesOfUser(Long id);
    public Issue getIssue(Long id);
    public void createIssue(Issue issue);
    public void updateIssue(Issue issue);
    public void removeIssue(Long id);
}
