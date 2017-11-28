package com.jlucka.mirror.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private String user;

    public String getUser() {
        return user != null ? user : "Test";
    }

    public void setUser(String user) {
        this.user = user;
    }
}
