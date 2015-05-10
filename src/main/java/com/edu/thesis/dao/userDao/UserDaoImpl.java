package com.edu.thesis.dao.userDao;

import com.edu.thesis.domain.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> listOfUsers() {
        return (List)sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional
    public User getUser(String userName) {
        Query query = sessionFactory.getCurrentSession().createQuery("select u from User u where u.login = :login");
        query.setString("login", userName);
        return (User)query.list().get(0);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        sessionFactory.getCurrentSession().delete(getUser(id));
    }
}
