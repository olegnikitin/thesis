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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (condition != null ? !condition.equals(issue.condition) : issue.condition != null) return false;
        if (criticality != null ? !criticality.equals(issue.criticality) : issue.criticality != null) return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(issue.dateOfCreation) : issue.dateOfCreation != null)
            return false;
        if (description != null ? !description.equals(issue.description) : issue.description != null) return false;
        if (screenshots != null ? !screenshots.equals(issue.screenshots) : issue.screenshots != null) return false;
        if (typeOfError != issue.typeOfError) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateOfCreation != null ? dateOfCreation.hashCode() : 0;
        result = 31 * result + (typeOfError != null ? typeOfError.hashCode() : 0);
        result = 31 * result + (criticality != null ? criticality.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (screenshots != null ? screenshots.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "dateOfCreation=" + dateOfCreation +
                ", typeOfError=" + typeOfError +
                ", criticality='" + criticality + '\'' +
                ", condition='" + condition + '\'' +
                ", description='" + description + '\'' +
                ", screenshots=" + screenshots +
                '}';
    }
}
