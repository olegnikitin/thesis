package com.edu.thesis.dao;

import com.edu.thesis.config.DBConfiguration;
import com.edu.thesis.config.MvcConfiguration;
import com.edu.thesis.config.TestDataBaseConfig;
import com.edu.thesis.dao.projectDao.ProjectDao;
import com.edu.thesis.dao.userDao.UserDao;
import com.edu.thesis.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Oleg on 17.04.2015.
 */
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
//@ContextConfiguration(classes = {MvcConfiguration.class, TestDataBaseConfig.class})//1 - ordinary, 2 - test
//@ContextConfiguration(classes = {MvcConfiguration.class, DBConfiguration.class})//Ordinary configuration
public class UserHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
//Failed to load ApplicationContext if @ContextConfiguration above

    /*@Autowired
    private UserDao userDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private SessionFactory sessionFactory;
    private Session session = sessionFactory.getCurrentSession();*/

    /*@BeforeClass//Method
    public void setUp() throws Exception {
        session = sessionFactory.getCurrentSession();
    }*/

    /*@Test
    @Ignore
    public void testCreate() {
        User user = new User();

        userDao.createUser(user);

        assertNotEquals("Id not created", (long)user.getId(), 0);

        session.evict(user);
        User result = (User) session.get(User.class, user.getId());

        assertEquals(user, result);
    }

    @Test
    @Ignore
    public void testGetInvalidId() {
        User result = userDao.getUser(-567890L);
        assertNull(result);
    }

    @Test
    @Ignore
    public void testUpdate() {
        String newName = "new name";
        User user = new User();
        session.save(user);
        user.setFirstName(newName);
        userDao.createUser(user);
        session.flush();
        session.evict(user);
        User result = (User) session.get(User.class, user.getId());//!
        assertEquals(result.getFirstName(), newName);
    }

    @Test
    @Ignore
    public void testDelete(){
        //TODO: Dao method delete must return boolean
    }*/

    /**
     * Showing workability of this class
     * @throws InterruptedException
     */
    @Test
    //@Ignore
    public void uselessMethod() throws InterruptedException {
        Thread.sleep(1000);
    }
}
