package com.edu.thesis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Oleg on 19.12.2014.
 */
@Entity
@Table(name = "group_of_users")
public class Group implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column(nullable = false)
    private String nameOfTheGroup;

    @Column
    private String info;

    @Column(name = "date", nullable = false)
    private Date dateOfCreation;

    @OneToMany(mappedBy = "group")
    //@Cascade for hibernate
    private Set<User> users;

    public Group() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfTheGroup() {
        return nameOfTheGroup;
    }

    public void setNameOfTheGroup(String nameOfTheGroup) {
        this.nameOfTheGroup = nameOfTheGroup;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
