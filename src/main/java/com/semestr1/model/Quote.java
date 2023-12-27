package com.semestr1.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Quote {
    private UUID uuid;
    private String text;
    private User author;
    private LocalDateTime createdTime;
    private Integer likes;
    private Integer dislikes;

    public Quote() {
    }

    public Quote(UUID uuid, String text, User author, LocalDateTime createdTime, Integer likes, Integer dislikes) {
        this.uuid = uuid;
        this.text = text;
        this.author = author;
        this.createdTime = createdTime;
        this.likes = likes;
        this.dislikes = dislikes;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }
}

