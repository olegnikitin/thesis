package com.edu.thesis.domain.factory;

import com.edu.thesis.domain.User;
import com.edu.thesis.domain.enums.RoleOfTheUser;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg on 18.04.2015.
 */
public class UserFactory {

    private static volatile UserFactory instance;

    public static UserFactory getInstance(){
        UserFactory localInstance = instance;
        if(localInstance == null){
            synchronized (UserFactory.class){
                localInstance = instance;
                if(localInstance == null){
                    instance = localInstance = new UserFactory();
                }
            }
        }
        return localInstance;
    }

    private UserFactory(){}

    public User getNewDefaultUser(){
        return new User();
    }

    public User getNewAdmin(){
        User user = new User();
        Set<RoleOfTheUser> roles = new HashSet<>();
        roles.add(RoleOfTheUser.ROLE_ADMIN);
        roles.add(RoleOfTheUser.ROLE_USER);
        user.setRolesOfTheUser(roles);
        return user;
    }

}
