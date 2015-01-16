package com.edu.thesis.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Oleg on 19.12.2014.
 */
@Entity
@Table(name = "storaged_file")
public class StoragedFile implements Serializable{

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoragedFile that = (StoragedFile) o;

        if (issue != null ? !issue.equals(that.issue) : that.issue != null) return false;
        if (pathToFile != null ? !pathToFile.equals(that.pathToFile) : that.pathToFile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pathToFile != null ? pathToFile.hashCode() : 0;
        result = 31 * result + (issue != null ? issue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoragedFile{" +
                "pathToFile='" + pathToFile + '\'' +
                ", issue=" + issue +
                '}';
    }
}
