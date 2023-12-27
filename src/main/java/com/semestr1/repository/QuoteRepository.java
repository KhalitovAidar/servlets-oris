package com.semestr1.repository;

import com.semestr1.dto.quote.QuoteRequest;
import com.semestr1.exception.quote.CanNotCreateQuoteException;
import com.semestr1.exception.user.CanNotCreateUserException;
import com.semestr1.mapper.QuoteMapper;
import com.semestr1.model.Quote;
import com.semestr1.model.User;
import com.semestr1.utils.DatabaseUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class QuoteRepository {
    private JdbcTemplate jdbcTemplate = DatabaseUtil.getJdbcTemplate();
    private UserRepository userRepository = new UserRepository();
    private final String SQL_GET_ALL = "select * from quotes";
    private final String SQL_CREATE_QUOTE = "insert into quotes(uuid, text, author_id, created_time) values(?, ?, ?, ?)";
    private final String SQL_GET_QUOTES_BY_USER_ID = "select * from quotes where author_id = ?";
    private final String SQL_GET_QUOTE_BY_ID = "select * from quotes where uuid = ?";

    private final RowMapper<Quote> rowMapper = (rs, rowNum) -> {
        Quote quote = new Quote();
        quote.setUuid((UUID) rs.getObject("uuid"));
        quote.setText(rs.getString("text"));
        quote.setAuthor(userRepository.getById((UUID) rs.getObject("author_id")));
        quote.setCreatedTime(rs.getObject("created_time", LocalDateTime.class));
        quote.setLikes(rs.getInt("likes"));
        quote.setDislikes(rs.getInt("dislikes"));
        return quote;
    };

    public List<Quote> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, rowMapper);
    }

    public UUID create(Quote quote) throws CanNotCreateQuoteException {
        quote.setUuid(UUID.randomUUID());
        quote.setCreatedTime(LocalDateTime.now());

        try {
            jdbcTemplate.update(SQL_CREATE_QUOTE, quote.getUuid(), quote.getText(), quote.getAuthor().getUuid(), quote.getCreatedTime());
            return quote.getUuid();
        } catch (DataIntegrityViolationException e) {
            throw new CanNotCreateQuoteException(e.getMessage());
        }

    }

    public List<Quote> getQuotesByUserId(UUID userId) {
        return jdbcTemplate.query(SQL_GET_QUOTES_BY_USER_ID, new Object[]{userId}, rowMapper);
    }

    public Quote getQuoteById(UUID uuid) {
        return jdbcTemplate.queryForObject(SQL_GET_QUOTE_BY_ID, new Object[]{uuid}, rowMapper);
    }
}
