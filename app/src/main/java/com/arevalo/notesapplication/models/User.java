package com.arevalo.notesapplication.models;

import com.orm.dsl.Table;

@Table
public class User {

    private Long id;
    private String name;
    private String fullname;
    private String email;
    private String password;

    public User(){

    }

    public User(String name, String fullname, String email, String password) {
        this.name = name;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
