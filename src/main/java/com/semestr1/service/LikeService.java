package com.semestr1.service;

import com.semestr1.repository.LikeRepository;

import java.util.UUID;

public class LikeService {
    private LikeRepository likeRepository;
    public void like(UUID quote, UUID user) {
        likeRepository.like(quote, user);
    }
}
