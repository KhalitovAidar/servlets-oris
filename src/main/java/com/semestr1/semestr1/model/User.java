package com.semestr1.semestr1.model;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID uuid;
    private String name;
    private String password;
    private List<Quote> quotes;

    public User(UUID uuid, String name, String password, List<Quote> quotes) {
        this.uuid = uuid;
        this.name = name;
        this.password = password;
        this.quotes = quotes;
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

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
