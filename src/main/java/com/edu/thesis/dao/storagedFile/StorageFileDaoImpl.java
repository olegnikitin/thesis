package com.edu.thesis.dao.storagedFile;

import com.edu.thesis.domain.StoragedFile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
@Repository
public class StorageFileDaoImpl implements StoragedFileDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<StoragedFile> listOfStoragedFile() {
        return (List)sessionFactory.getCurrentSession().createQuery("from StoragedFile").list();
    }

    @Override
    @Transactional
    public StoragedFile getStoragedFile(Long id) {
        return (StoragedFile) sessionFactory.getCurrentSession().get(StoragedFile.class, id);
    }

    @Override
    @Transactional
    public void createStoragedFile(StoragedFile storagedFile) {
        sessionFactory.getCurrentSession().save(storagedFile);
    }

    @Override
    @Transactional
    public void updateStoragedFile(StoragedFile storagedFile) {
        sessionFactory.getCurrentSession().update(storagedFile);
    }

    @Override
    @Transactional
    public void removeStoragedFile(Long id) {
        sessionFactory.getCurrentSession().delete(getStoragedFile(id));
    }
}
