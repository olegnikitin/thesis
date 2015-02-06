package com.edu.thesis.web.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Oleg on 06.02.2015.
 */
@Component
public class ProjectDto {

    @NotEmpty
    private String nameOfTheProject;

    private long leadOfTheProject;

    private long[] issues;

    public String getNameOfTheProject() {
        return nameOfTheProject;
    }

    public void setNameOfTheProject(String nameOfTheProject) {
        this.nameOfTheProject = nameOfTheProject;
    }

    public long getLeadOfTheProject() {
        return leadOfTheProject;
    }

    public void setLeadOfTheProject(long leadOfTheProject) {
        this.leadOfTheProject = leadOfTheProject;
    }

    public long[] getIssues() {
        return issues;
    }

    public void setIssues(long[] issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "nameOfTheProject='" + nameOfTheProject + '\'' +
                ", leadOfTheProject=" + leadOfTheProject +
                ", issues=" + Arrays.toString(issues) +
                '}';
    }
}
