package com.edu.thesis.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Oleg on 19.12.2014.
 */
@Entity
@Table(name = "storaged_file")
public class StoragedFile implements DomainObject{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String pathToFile;

    @ManyToOne
    @JoinColumn(name = "issue_fk")
    private Issue issue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, new String[]
                {"id", "issue"});//excluding this fields
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]
                {"id", "issue"});//excluding this fields
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);//TODO: Check the realization
    }
}
