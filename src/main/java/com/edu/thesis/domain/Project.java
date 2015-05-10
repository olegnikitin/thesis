package com.edu.thesis.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Oleg on 16.01.2015.
 */
@Entity
@Table(name = "table_project")
@Inheritance(strategy = InheritanceType.JOINED)
@Document(indexName = "project")
public class Project implements DomainObject{

    private static final long serialVersionUID = 45456754633L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Name of the project mustn\'t be empty")
    private String nameOfTheProject;

    @Column
    private String descriptionOfTheProject;

    @OneToOne
    private User leadOfTheProject;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="project_user",
            joinColumns = @JoinColumn(name="project_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id")
    )
    private Set<User> usersInTheCurrentProject;
    //List of issues add to DAO?

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
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, new String[]
                {"id", "leadOfTheProject", "usersInTheCurrentProject"});//excluding this fields
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]
                {"id", "leadOfTheProject", "usersInTheCurrentProject"});//excluding this fields
    }
}