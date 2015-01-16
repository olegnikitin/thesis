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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (dateOfCreation != null ? !dateOfCreation.equals(group.dateOfCreation) : group.dateOfCreation != null)
            return false;
        if (info != null ? !info.equals(group.info) : group.info != null) return false;
        if (nameOfTheGroup != null ? !nameOfTheGroup.equals(group.nameOfTheGroup) : group.nameOfTheGroup != null)
            return false;
        if (users != null ? !users.equals(group.users) : group.users != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nameOfTheGroup != null ? nameOfTheGroup.hashCode() : 0;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "nameOfTheGroup='" + nameOfTheGroup + '\'' +
                ", info='" + info + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", users=" + users +
                '}';
    }
}
