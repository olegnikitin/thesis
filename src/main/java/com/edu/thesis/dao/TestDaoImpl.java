package com.edu.thesis.dao;

import com.edu.thesis.domain.Test;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.naming.OperationNotSupportedException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oleg on 12.01.2015.
 */
@Repository
public class TestDaoImpl implements TestDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Test> listOfTests(){
        return (List)sessionFactory.getCurrentSession().createQuery("from Test").list();
    }

    @Override
    @Transactional
    public Test getTest(Long id) {
        return (Test)sessionFactory.getCurrentSession().get(Test.class, id);
    }

    @Override
    @Transactional
    public void addTest(Test test) {
        sessionFactory.getCurrentSession().save(test);
    }

    @Override
    @Transactional
    public void editTest(Test test) {
        sessionFactory.getCurrentSession().update(test);
    }

    @Override
    @Transactional
    public void removeTest(Long id) {
        sessionFactory.getCurrentSession().delete(getTest(id));
    }
}
