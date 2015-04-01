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
@Table(name = "user_of_the_bugtracker")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column(unique = true)
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
    private String login;

    @Column
    @Size(min = 3)
    private String firstName;

    @Column
    @Size(min = 3)
    private String lastName;

    @Column
    @Size(min = 3)
    private String middleName;

    @Column
    @Pattern(regexp = ".+@.+")
    private String email;

    @Column(name = "date_of_registration")
    private Date dateOfRegistration;

    @Column
    @Size(min=6, max=20, message="The password must be between 6 and 20 characters long.")
    private String password;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<RoleOfTheUser> rolesOfTheUser;

    @OneToMany(mappedBy = "ownerOfTheTask")
    private Set<Issue> tasks;

    public User() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<RoleOfTheUser> getRolesOfTheUser() {
        return rolesOfTheUser;
    }

    public void setRolesOfTheUser(Set<RoleOfTheUser> rolesOfTheUser) {
        this.rolesOfTheUser = rolesOfTheUser;
    }

    public Set<Issue> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Issue> tasks) {
        this.tasks = tasks;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "User{" +
                "tasks=" + tasks +
                ", rolesOfTheUser=" + rolesOfTheUser +
                ", password='" + password + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                ", email='" + email + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (middleName != null ? !middleName.equals(user.middleName) : user.middleName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (dateOfRegistration != null ? !dateOfRegistration.equals(user.dateOfRegistration) : user.dateOfRegistration != null)
            return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dateOfRegistration != null ? dateOfRegistration.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
