package com.example.servlets;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<String> roles = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRole(String role) {
        roles.add(role);
    }

    public String[] getRoles() {
        return roles.toArray(new String[0]);
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", roles=" + (roles.toString()) + "]";
    }
}
