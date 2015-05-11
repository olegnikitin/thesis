package com.edu.thesis.service.projectService;

import com.edu.thesis.domain.Project;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 19.01.2015.
 */
@Service
public interface ProjectService {
    public List<Project> listOfProjects();
    public List<Project> listOfProjectsByUser(Long id);
    public Project getProject(Long id);
    public void createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Long id);
}
