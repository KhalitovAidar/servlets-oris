package com.semestr1.dto.quote;

import com.semestr1.model.User;

import java.time.LocalDateTime;

public record QuoteResponse(String text, User author, LocalDateTime createdTime, Integer likes, Integer dislikes) {
}
