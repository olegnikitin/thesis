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

    private String descriptionOfTheProject;

    private long leadOfTheProject;

    private long[] issues;

    private long[] usersInTheCurrentProject;

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

    public String getDescriptionOfTheProject() {
        return descriptionOfTheProject;
    }

    public void setDescriptionOfTheProject(String descriptionOfTheProject) {
        this.descriptionOfTheProject = descriptionOfTheProject;
    }

    public long[] getUsersInTheCurrentProject() {
        return usersInTheCurrentProject;
    }

    public void setUsersInTheCurrentProject(long[] usersInTheCurrentProject) {
        this.usersInTheCurrentProject = usersInTheCurrentProject;
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
