package com.semestr1.semestr1.dto;

import com.semestr1.semestr1.model.Quote;

import java.util.List;

public record UserResponse(String name, List<Quote> quotes) {
}