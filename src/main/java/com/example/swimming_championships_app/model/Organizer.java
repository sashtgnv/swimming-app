package com.example.swimming_championships_app.model;

import jakarta.persistence.*;

@Entity
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    private String login;
    private String password;

    public Organizer() {
    }

    public Organizer(Integer id, String fullName, String login, String password) {
        this.id = id;
        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "\n\tid=" + id +
                "\n\tfullName='" + fullName + '\'' +
                "\n\tlogin='" + login + '\'' +
                "\n\tpassword='" + password + '\'' +
                '}';
    }
}
