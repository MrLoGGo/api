package com.example.api.model;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;
    private String login;
    private String password;

    public Users() {
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
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
}
