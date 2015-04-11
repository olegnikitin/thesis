package com.edu.thesis.domain;

import com.edu.thesis.domain.enums.PriorityOfTheTask;
import com.edu.thesis.domain.enums.StatusOfTheTask;
import com.edu.thesis.domain.enums.TypeOfTheTask;
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
public class Issue implements Serializable{

    private static final long serialVersionUID = 845545621L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String nameOfIssue;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private PriorityOfTheTask priority;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfTheTask type;

    @Column
    private Date dateOfCreation;

    @Column
    private Date dateOfModification;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusOfTheTask statusOfTheTask;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "project_fk")
    private Project projectOfTheIssue;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_fk")
    private User ownerOfTheTask;

    @OneToMany(mappedBy = "issue", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
        return "Issue{" +
                "nameOfIssue='" + nameOfIssue + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", type=" + type +
                ", dateOfCreation=" + dateOfCreation +
                ", dateOfModification=" + dateOfModification +
                ", statusOfTheTask=" + statusOfTheTask +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (id != null ? !id.equals(issue.id) : issue.id != null) return false;
        if (nameOfIssue != null ? !nameOfIssue.equals(issue.nameOfIssue) : issue.nameOfIssue != null) return false;
        if (description != null ? !description.equals(issue.description) : issue.description != null) return false;
        if (priority != issue.priority) return false;
        if (type != issue.type) return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(issue.dateOfCreation) : issue.dateOfCreation != null)
            return false;
        if (dateOfModification != null ? !dateOfModification.equals(issue.dateOfModification) : issue.dateOfModification != null)
            return false;
        return statusOfTheTask == issue.statusOfTheTask;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameOfIssue != null ? nameOfIssue.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (dateOfModification != null ? dateOfModification.hashCode() : 0);
        result = 31 * result + (statusOfTheTask != null ? statusOfTheTask.hashCode() : 0);
        return result;
    }
}
