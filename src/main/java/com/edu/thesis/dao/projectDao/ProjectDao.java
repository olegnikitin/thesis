package com.edu.thesis.dao.projectDao;

import com.edu.thesis.domain.Project;

import java.util.List;

/**
 * Created by Oleg on 19.01.2015.
 */
public interface ProjectDao {
    public List<Project> listOfProjects();
    public Project getProject(Long id);
    public void createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Long id);
}
