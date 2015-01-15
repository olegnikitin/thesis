package com.edu.thesis.service;

import com.edu.thesis.dao.TestDao;
import com.edu.thesis.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 12.01.2015.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> listOfTests() {
        return null;
    }

    @Override
    public Test getTest(Long id) {
        return testDao.getTest(id);
    }

    @Override
    public void addTest(Test test) {
        testDao.addTest(test);
    }

    @Override
    public void editTest(Test test) {
        testDao.editTest(test);
    }

    @Override
    public void removeTest(Long id) {
        testDao.removeTest(id);
    }
}
