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

}
