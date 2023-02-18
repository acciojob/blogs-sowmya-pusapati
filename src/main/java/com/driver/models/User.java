package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Blog> blogList=new ArrayList<>();

    public User() {
    }

    public User(int userId, String userName, String password, String firstName, String lastName) {
        this.userId=userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public int getId() {
        return userId;
    }

    public void setId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}