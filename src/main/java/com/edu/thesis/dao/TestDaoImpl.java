package com.edu.thesis.dao;

import com.edu.thesis.domain.Test;
import org.apache.log4j.Logger;
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

    private static final Logger log = Logger.getLogger(TestDaoImpl.class);

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
        log.info(test.toString());
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
