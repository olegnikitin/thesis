package com.edu.thesis.dao.groupDao;

import com.edu.thesis.domain.Group;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oleg on 13.01.2015.
 */
@Repository
public class GroupDaoImpl implements GroupDao {

    private static final Logger log = Logger.getLogger(GroupDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Group> listOfGroup() {
    return (List)sessionFactory.getCurrentSession().createQuery("from Group").list();
    }

    @Override
    @Transactional
    public void createGroup(Group group) {
        sessionFactory.getCurrentSession().save(group);
    }

    @Override
    @Transactional
    public Group getGroup(Long id) {
        return (Group) sessionFactory.getCurrentSession().get(Group.class, id);
    }

    @Override
    @Transactional
    public void updateGroup(Group group) {
        sessionFactory.getCurrentSession().update(group);
    }

    @Override
    @Transactional
    public void removeGroup(Long id) {
        sessionFactory.getCurrentSession().delete(getGroup(id));
    }
}
