package com.edu.thesis.domain;

import com.edu.thesis.domain.enums.RoleOfTheUser;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Oleg on 19.12.2014.
 */
@Entity
@Table(name = "user_of_the_group")
public class User implements Serializable{
//http://stackoverflow.com/questions/8714491/hibernate-and-mysql-with-create-drop-option-console-output-shows-error-but
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
    private String login;

    @Column
    @Size(min = 3)
    private String firstName;

    @Column
    @Size(min = 3)
    private String lastName;

    @Column
    @Pattern(regexp = "/.+@.+\\..+/i")
    private String email;

    @Column(name = "date")
    private Date dateOfRegistration;

    @Column
    @Size(min=6, max=20, message="The password must be between 6 and 20 characters long.")
    private String password;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<RoleOfTheUser> rolesOfTheUser;

    @ManyToOne
    @JoinColumn(name = "group_fk")
    private Group group;

    public User() {    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<RoleOfTheUser> getRolesOfTheUser() {
        return rolesOfTheUser;
    }

    public void setRolesOfTheUser(Set<RoleOfTheUser> rolesOfTheUser) {
        this.rolesOfTheUser = rolesOfTheUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
