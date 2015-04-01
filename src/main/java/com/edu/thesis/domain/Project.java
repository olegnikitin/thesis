package com.edu.thesis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Oleg on 16.01.2015.
 */
@Entity
@Table(name = "table_project")
public class Project implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String nameOfTheProject;

    @Column
    private String descriptionOfTheProject;

    @OneToOne
    private User leadOfTheProject;

    @OneToMany(mappedBy = "projectOfTheIssue", fetch = FetchType.EAGER)
    private Set<Issue> issues;

    public Project() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfTheProject() {
        return nameOfTheProject;
    }

    public void setNameOfTheProject(String nameOfTheProject) {
        this.nameOfTheProject = nameOfTheProject;
    }

    public User getLeadOfTheProject() {
        return leadOfTheProject;
    }

    public void setLeadOfTheProject(User leadOfTheProject) {
        this.leadOfTheProject = leadOfTheProject;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public String getDescriptionOfTheProject() {
        return descriptionOfTheProject;
    }

    public void setDescriptionOfTheProject(String descriptionOfTheProject) {
        this.descriptionOfTheProject = descriptionOfTheProject;
    }

    @Override
    public String toString() {
        return "Project{" +
                "nameOfTheProject='" + nameOfTheProject + '\'' +
                ", descriptionOfTheProject='" + descriptionOfTheProject + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (nameOfTheProject != null ? !nameOfTheProject.equals(project.nameOfTheProject) : project.nameOfTheProject != null)
            return false;
        return !(descriptionOfTheProject != null ? !descriptionOfTheProject.equals(project.descriptionOfTheProject) : project.descriptionOfTheProject != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameOfTheProject != null ? nameOfTheProject.hashCode() : 0);
        result = 31 * result + (descriptionOfTheProject != null ? descriptionOfTheProject.hashCode() : 0);
        return result;
    }
}