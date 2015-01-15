package com.edu.thesis.service.storagedFileService;

import com.edu.thesis.dao.storagedFile.StoragedFileDao;
import com.edu.thesis.domain.StoragedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
@Service
public class StorageFileServiceImpl implements StoragedFileService {

    @Autowired
    private StoragedFileDao storagedFileDao;

    @Override
    public List<StoragedFile> listOfStoragedFile() {
        return storagedFileDao.listOfStoragedFile();
    }

    @Override
    public StoragedFile getStoragedFile(Long id) {
        return storagedFileDao.getStoragedFile(id);
    }

    @Override
    public void createStoragedFile(StoragedFile storagedFile) {
        storagedFileDao.createStoragedFile(storagedFile);
    }

    @Override
    public void updateStoragedFile(StoragedFile storagedFile) {
        storagedFileDao.updateStoragedFile(storagedFile);
    }

    @Override
    public void removeStoragedFile(Long id) {
        storagedFileDao.removeStoragedFile(id);
    }
}
