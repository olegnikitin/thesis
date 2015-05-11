package com.edu.thesis.service.projectService;

import com.edu.thesis.dao.projectDao.ProjectDao;
import com.edu.thesis.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 19.01.2015.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> listOfProjects() {
        return projectDao.listOfProjects();
    }

    public List<Project> listOfProjectsByUser(Long id){
        return projectDao.listOfProjectsByUser(id);
    }

    @Override
    public Project getProject(Long id) {
        return projectDao.getProject(id);
    }

    @Override
    public void createProject(Project project) {
        projectDao.createProject(project);
    }

    @Override
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectDao.deleteProject(id);
    }
}
