package com.edu.thesis.service.issueService;

import com.edu.thesis.dao.issueDao.IssueDao;
import com.edu.thesis.domain.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueDao issueDao;

    @Override
    public List<Issue> listOfIssues() {
        return issueDao.listOfIssues();
    }

    @Override
    public Issue getIssue(Long id) {
        return issueDao.getIssue(id);
    }

    @Override
    public void createIssue(Issue issue) {
        issueDao.createIssue(issue);
    }

    @Override
    public void updateIssue(Issue issue) {
        issueDao.updateIssue(issue);
    }

    @Override
    public void removeIssue(Long id) {
        issueDao.removeIssue(id);
    }
}
