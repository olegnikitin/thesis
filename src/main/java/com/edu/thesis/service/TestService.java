package com.edu.thesis.service;

import com.edu.thesis.domain.Test;

import java.util.List;

/**
 * Created by Oleg on 12.01.2015.
 */
public interface TestService {
    public List<Test> listOfTests();
    public Test getTest(Long id);
    public void addTest(Test test);
    public void editTest(Test test);
    public void removeTest(Long id);
}
