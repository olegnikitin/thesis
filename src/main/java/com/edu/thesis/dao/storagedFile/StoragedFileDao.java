package com.edu.thesis.dao.storagedFile;

import com.edu.thesis.domain.StoragedFile;

import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
public interface StoragedFileDao {
    public List<StoragedFile> listOfStoragedFile();
    public StoragedFile getStoragedFile(Long id);
    public void createStoragedFile(StoragedFile storagedFile);
    public void updateStoragedFile(StoragedFile storagedFile);
    public void removeStoragedFile(Long id);
}
