package com.adventureAPI.AdventureAPI.dto;

import java.util.Date;

public class AuthResponse {
    private String token;
    private Date expiration;

    public AuthResponse(String token, Date expiration) {
        this.token = token;
        this.expiration = expiration;
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}