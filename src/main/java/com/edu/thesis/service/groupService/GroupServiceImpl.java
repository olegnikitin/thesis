package com.edu.thesis.service.groupService;

import com.edu.thesis.dao.groupDao.GroupDao;
import com.edu.thesis.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> listOfGroup() {
        return groupDao.listOfGroup();
    }

    @Override
    public void createGroup(Group group) {
        groupDao.createGroup(group);
    }

    @Override
    public Group getGroup(Long id) {
        return groupDao.getGroup(id);
    }

    @Override
    public void updateGroup(Group group) {
        groupDao.updateGroup(group);
    }

    @Override
    public void removeGroup(Long id) {
        groupDao.removeGroup(id);
    }
}
