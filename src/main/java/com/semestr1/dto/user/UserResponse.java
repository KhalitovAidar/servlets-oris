package com.semestr1.dto.user;

import com.semestr1.model.Quote;

import java.util.List;

public record UserResponse(String name, List<Quote> quotes) {
}