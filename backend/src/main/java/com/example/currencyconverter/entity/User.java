package com.example.currencyconverter.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String apiKey;

    @Column(nullable = false)
    private String username;

    protected User(){

    }

    public User(String username, String apiKey){
        this.username = username;
        this.apiKey = apiKey;
    }

    public long getId() {
        return id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUsername() {
        return username;
    }
}
