package com.edu.thesis.dao.issueDao;

import com.edu.thesis.domain.Issue;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
@Repository
public class IssueDaoImpl implements IssueDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Issue> listOfIssues() {
        return (List)sessionFactory.getCurrentSession().createQuery("from Issue").list();
    }

    @Override
    @Transactional
    public Issue getIssue(Long id) {
        return (Issue) sessionFactory.getCurrentSession().get(Issue.class, id);
    }

    @Override
    @Transactional
    public void createIssue(Issue issue) {
        sessionFactory.getCurrentSession().save(issue);
    }

    @Override
    @Transactional
    public void updateIssue(Issue issue) {
        sessionFactory.getCurrentSession().update(issue);
    }

    @Override
    @Transactional
    public void removeIssue(Long id) {
        sessionFactory.getCurrentSession().delete(getIssue(id));
    }
}
