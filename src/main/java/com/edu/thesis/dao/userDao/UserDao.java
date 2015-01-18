package com.edu.thesis.dao.userDao;

import com.edu.thesis.domain.User;

import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
public interface UserDao {
    public List<User> listOfUsers();
    public User getUser(Long id);
    public User getUser(String userName);
    public void createUser(User user);
    public void updateUser(User user);
    public void removeUser(Long id);
}
