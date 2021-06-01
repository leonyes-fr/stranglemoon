package com.stranglemoon.stranglemoon.model;

import javax.persistence.*;

@Entity
@Table(name= "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  username;

    private String password;

    private String token;

    @OneToOne
    @JoinColumn(name = "constructioninstanceid", referencedColumnName = "id")
    private ConstructionInstance constructionInstance;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
