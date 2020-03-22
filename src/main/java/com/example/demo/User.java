package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Size(min=7, max=30)
    private String username;
    //@NotEmpty(message = "Please enter your password.")
    //@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
    private String password;
    //@Email
    private String email;
    @Column(name = "first_name")
    //@NotEmpty(message = "Please enter your password.")
    private String firstname;
    //@NotEmpty(message = "Please enter your password.")
    @Column(name = "last_name")
    private String lastname;

    public User() {
    }

    public User(String firstname, String lastname, String email, String password, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

