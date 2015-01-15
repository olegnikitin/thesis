package com.edu.thesis.dao.groupDao;

import com.edu.thesis.domain.Group;

import java.util.List;

/**
 * Created by Oleg on 13.01.2015.
 */
public interface GroupDao {
    public List<Group> listOfGroup();
    public void createGroup(Group group);
    public Group getGroup(Long id);
    public void updateGroup(Group group);
    public void removeGroup(Long id);
}
