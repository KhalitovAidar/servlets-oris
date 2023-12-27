package com.semestr1.model;

import java.util.UUID;

public class Comment {
    private UUID uuid;
    private String text;
    private UUID user;
    private UUID quote;

    public Comment() {
    }

    public Comment(UUID uuid, String text, UUID user, UUID quote) {
        this.uuid = uuid;
        this.text = text;
        this.user = user;
        this.quote = quote;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public UUID getQuote() {
        return quote;
    }

    public void setQuote(UUID quote) {
        this.quote = quote;
    }
}
