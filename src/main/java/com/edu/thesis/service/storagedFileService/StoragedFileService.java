package com.edu.thesis.service.storagedFileService;

import com.edu.thesis.domain.StoragedFile;

import java.util.List;

/**
 * Created by Oleg on 14.01.2015.
 */
public interface StoragedFileService {
    public List<StoragedFile> listOfStoragedFile();
    public StoragedFile getStoragedFile(Long id);
    public void createStoragedFile(StoragedFile storagedFile);
    public void updateStoragedFile(StoragedFile storagedFile);
    public void removeStoragedFile(Long id);
}
