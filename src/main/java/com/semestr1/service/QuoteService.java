package com.semestr1.service;

import com.semestr1.dto.quote.QuoteRequest;
import com.semestr1.dto.quote.QuoteResponse;
import com.semestr1.exception.quote.CanNotCreateQuoteException;
import com.semestr1.mapper.QuoteMapper;
import com.semestr1.model.Quote;
import com.semestr1.model.User;
import com.semestr1.repository.QuoteRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class QuoteService {
    private QuoteRepository quoteRepository = new QuoteRepository();
    private QuoteMapper mapper = Mappers.getMapper(QuoteMapper.class);

    public QuoteService(QuoteRepository quoteRepository) {
    }

    public List<Quote> getAll() {
        List<Quote> quotes = quoteRepository.getAll();
        return quotes;
    }

    public void create(QuoteRequest quoteRequest) throws CanNotCreateQuoteException {
        Quote quote = mapper.toEntity(quoteRequest);

        quoteRepository.create(quote);
    }

    public List<Quote> getQuotesByUserId(UUID uuid) {
        return quoteRepository.getQuotesByUserId(uuid);
    }

    public Quote getQuoteById(UUID uuid) {
        return quoteRepository.getQuoteById(uuid);
    }
}
