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
}
