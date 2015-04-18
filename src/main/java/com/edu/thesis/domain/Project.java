package com.edu.thesis.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Oleg on 16.01.2015.
 */
@Entity
@Table(name = "table_project")
@Inheritance(strategy = InheritanceType.JOINED)
@Document(indexName = "project")
public class Project implements Serializable{

    private static final long serialVersionUID = 45456754633L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotEmpty(message = "Name of the project mustn\'t be empty")
    private String nameOfTheProject;

    @Column
    private String descriptionOfTheProject;

    @OneToOne
    @NotEmpty(message = "Lead of the project mustn\'t be empty")
    private User leadOfTheProject;

    @ManyToMany
    @JoinTable(name="project_user",
            joinColumns = @JoinColumn(name="project_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id")
    )
    private Set<User> usersInTheCurrentProject;

    @OneToMany(mappedBy = "projectOfTheIssue", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Set<User> getUsersInTheCurrentProject() {
        return usersInTheCurrentProject;
    }

    public void setUsersInTheCurrentProject(Set<User> usersInTheCurrentProject) {
        this.usersInTheCurrentProject = usersInTheCurrentProject;
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