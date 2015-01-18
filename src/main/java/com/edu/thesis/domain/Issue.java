package com.edu.thesis.domain;

import com.edu.thesis.domain.enums.StatusOfTheTask;
import com.edu.thesis.domain.enums.TypeOfError;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Oleg on 19.12.2014.
 */
@Entity
@Table(name = "issue_of_the_task")
public class Issue implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String nameOfIssue;

    @Column
    private String description;

    @Column
    private String criticality;

    @Column
    private Date dateOfCreation;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfError typeOfError;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusOfTheTask statusOfTheTask;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @ManyToOne
    @JoinColumn(name = "project_fk") //nullable = false
    private Project projectOfTheIssue;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User ownerOfTheTask;

    @OneToMany(mappedBy = "issue")
    private Set<StoragedFile> screenshots;

    public Issue() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfIssue() {
        return nameOfIssue;
    }

    public void setNameOfIssue(String nameOfIssue) {
        this.nameOfIssue = nameOfIssue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public TypeOfError getTypeOfError() {
        return typeOfError;
    }

    public void setTypeOfError(TypeOfError typeOfError) {
        this.typeOfError = typeOfError;
    }

    public StatusOfTheTask getStatusOfTheTask() {
        return statusOfTheTask;
    }

    public void setStatusOfTheTask(StatusOfTheTask statusOfTheTask) {
        this.statusOfTheTask = statusOfTheTask;
    }

    public Project getProjectOfTheIssue() {
        return projectOfTheIssue;
    }

    public void setProjectOfTheIssue(Project projectOfTheIssue) {
        this.projectOfTheIssue = projectOfTheIssue;
    }

    public Set<StoragedFile> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(Set<StoragedFile> screenshots) {
        this.screenshots = screenshots;
    }

    public User getOwnerOfTheTask() {
        return ownerOfTheTask;
    }

    public void setOwnerOfTheTask(User ownerOfTheTask) {
        this.ownerOfTheTask = ownerOfTheTask;
    }
}
