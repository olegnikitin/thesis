package com.edu.thesis.dao.projectDao;

import com.edu.thesis.domain.Project;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oleg on 19.01.2015.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Project> listOfProjects() {
        return (List)sessionFactory.getCurrentSession().createQuery("from Project").list();
    }

    @Override
    @Transactional
    public List<Project> listOfProjectsByUser(Long id){
        Query query = sessionFactory.getCurrentSession().createQuery
                ("select p from Project p where p.leadOfTheProject = :id");
        query.setString("id", id.toString());
        return query.list();
    }

    @Override
    @Transactional
    public Project getProject(Long id) {
        return (Project) sessionFactory.getCurrentSession().get(Project.class, id);
    }

    @Override
    @Transactional
    public void createProject(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        sessionFactory.getCurrentSession().update(project);
    }

    @Override
    @Transactional
    public void deleteProject(Long id) {
        sessionFactory.getCurrentSession().delete(getProject(id));
    }
}
