package com.semestr1.model;

import java.util.UUID;

public class Like {
    private UUID uuid;
    private Integer count;
    private UUID quote;
    private UUID user;

    public Like() {
    }

    public Like(UUID uuid, Integer count, UUID quote, UUID user) {
        this.uuid = uuid;
        this.count = count;
        this.quote = quote;
        this.user = user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public UUID getQuote() {
        return quote;
    }

    public void setQuote(UUID quote) {
        this.quote = quote;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }
}
