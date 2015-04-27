package com.edu.thesis.domain.factory;

import com.edu.thesis.domain.User;
import com.edu.thesis.domain.enums.RoleOfTheUser;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg on 18.04.2015.
 */
public class UserFactory {

    private UserFactory(){}

    public synchronized static User getNewDefaultUser(){
        return new User();
    }

    public synchronized static User getNewAdmin(){
        User user = new User();
        Set<RoleOfTheUser> roles = new HashSet<>();
        roles.add(RoleOfTheUser.ROLE_ADMIN);
        roles.add(RoleOfTheUser.ROLE_USER);
        user.setRolesOfTheUser(roles);
        return user;
    }

}
