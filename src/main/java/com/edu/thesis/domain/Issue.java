package com.edu.thesis.domain;

import com.edu.thesis.domain.enums.PriorityOfTheTask;
import com.edu.thesis.domain.enums.StatusOfTheTask;
import com.edu.thesis.domain.enums.TypeOfTheTask;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Oleg on 19.12.2014.
 */
@Entity
@Table(name = "issue_of_the_task")
@Inheritance(strategy = InheritanceType.JOINED)
@Document(indexName = "issue")
public class Issue implements DomainObject{

    private static final long serialVersionUID = 845545621L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotEmpty(message = "Name of the task mustn\'t be empty")
    private String nameOfIssue;

    @Column
    @NotEmpty(message = "Description mustn\'t be empty")
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private PriorityOfTheTask priority;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfTheTask type;

    @Column
    private Date dateOfCreation = setDefaultDateOfCreation();

    @Column
    private Date dateOfModification;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusOfTheTask statusOfTheTask;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "project_fk")
    private Project projectOfTheIssue;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_fk")
    private User ownerOfTheTask;

    @OneToMany(mappedBy = "issue", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<StoragedFile> screenshots;

    public Issue() {    }

    private synchronized static Date setDefaultDateOfCreation(){
        return new Date();
    }

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

    public PriorityOfTheTask getPriority() {
        return priority;
    }

    public void setPriority(PriorityOfTheTask priority) {
        this.priority = priority;
    }

    public TypeOfTheTask getType() {
        return type;
    }

    public void setType(TypeOfTheTask type) {
        this.type = type;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
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

    public User getOwnerOfTheTask() {
        return ownerOfTheTask;
    }

    public void setOwnerOfTheTask(User ownerOfTheTask) {
        this.ownerOfTheTask = ownerOfTheTask;
    }

    public Set<StoragedFile> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(Set<StoragedFile> screenshots) {
        this.screenshots = screenshots;
    }

    public Date getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(Date dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);//TODO: Check the realization
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, new String[]
                {"id", "ownerOfTheTask", "projectOfTheIssue"});//excluding this fields
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]
                {"id", "ownerOfTheTask", "projectOfTheIssue"});//excluding this fields
    }
}
