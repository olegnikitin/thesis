package com.edu.thesis.domain;

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
    private Date dateOfCreation;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfError typeOfError;

    @Column
    private String criticality;

    @Column(name = "conditionOfTheTask")
    private String condition;

    @Column
    private String description;

    @OneToMany(mappedBy = "issue")
    private Set<StoragedFile> screenshots;

    public Issue() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StoragedFile> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(Set<StoragedFile> screenshots) {
        this.screenshots = screenshots;
    }
}
