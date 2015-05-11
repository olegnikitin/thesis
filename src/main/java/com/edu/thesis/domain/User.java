package com.edu.thesis.domain;

import com.edu.thesis.domain.enums.RoleOfTheUser;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg on 19.12.2014.
 */
@Entity
@Table(name = "user_of_the_bugtracker")
@Inheritance(strategy = InheritanceType.JOINED)
@Document(indexName = "user")
public class User implements DomainObject{

    private static final long serialVersionUID = 4532137696L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column(unique = true, length = 50)
    @Size(min = 4, max = 50, message = "The size of login must be from 4 to 50 symbols")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message = "Login must be alphanumeric with no spaces")
    @NotEmpty(message = "Login mustn\'t be empty")
    private String login;

    @Column(length = 50)
    @Size(min = 3, max = 50, message = "Size of the first name must be between 3 and 50 letters")
    @NotEmpty(message = "First name mustn\'t be empty")
    private String firstName;

    @Column(length = 50)
    @Size(min = 3, message = "Size of the last name must be between 3 and 50 letters")
    @NotEmpty(message = "Last name mustn\'t be empty")
    private String lastName;

    @Column(length = 60)
    @Size(min = 3, max = 60, message = "Size of the middle name must be between 3 and 60 letters")
    private String middleName;

    @Column(length = 100)
    @Size(min = 5, max = 100, message = "Size of the email must be between 3 and 60 letters")
    @Pattern(regexp = ".+@.+", message = "Email isn't valid")
    @NotEmpty(message = "Size of email mustn\'t be empty")
    private String email;

    @Column(name = "date_of_registration")
    private Date dateOfRegistration = setDateByRegistration();

    @Column
    @Size(min=6, max=20, message = "The password must be between 6 and 20 characters long")
    @NotEmpty(message = "Size of password mustn\'t be empty")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<RoleOfTheUser> rolesOfTheUser = setDefaultRoles();

    /*@OneToMany(mappedBy = "ownerOfTheTask", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Issue> tasks;*/

    public User() {    }

    private static Set<RoleOfTheUser> setDefaultRoles() {
        Set<RoleOfTheUser> defaultRoles = new HashSet<>();
        defaultRoles.add(RoleOfTheUser.ROLE_USER);
        return defaultRoles;
    }

    private static Date setDateByRegistration(){
        return new Date();
    }

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

    /*public Set<Issue> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Issue> tasks) {
        this.tasks = tasks;
    }*/

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);//TODO: Check the realization
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, new String[]
                {"id"});//excluding this fields
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]
                {"id"});//excluding this fields
    }
}
