package com.semestr1.model;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String name;
    private String password;

    public User(UUID uuid, String name, String password) {
        this.uuid = uuid;
        this.name = name;
        this.password = password;
    }

    public User() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
