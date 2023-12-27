package com.semestr1.dto.quote;

import com.semestr1.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record QuoteRequest(String text, User author) {
}
