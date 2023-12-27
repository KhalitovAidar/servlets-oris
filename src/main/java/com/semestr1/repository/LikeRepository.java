package com.semestr1.repository;

import com.semestr1.model.Like;
import com.semestr1.model.Quote;
import com.semestr1.utils.DatabaseUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class LikeRepository {
    private JdbcTemplate jdbcTemplate = DatabaseUtil.getJdbcTemplate();
    private final RowMapper<Like> rowMapper = (rs, rowNum) -> {
        Like like = new Like();
        like.setUuid((UUID) rs.getObject("uuid"));
        like.setCount(rs.getInt("count"));
        like.setQuote((UUID) rs.getObject("quote_id"));
        like.setQuote((UUID) rs.getObject("author_id"));

        return like;
    };
    private final String SQL_SELECT = "select * from likes where quote_id = ? and author_id = ?";
    private final String SQL_LIKE = "insert into likes()";
    public void like(UUID quote, UUID user) {
        Like like = getLike(quote, user);
        if(like != null) {
            int newCount = like.getCount() - 1;
            jdbcTemplate.update("UPDATE likes SET count = ? WHERE quote_id = ? and author_id = ?", newCount, quote, user);
        }else {
            jdbcTemplate.update(SQL_LIKE, quote, user);
        }
    }

    public Like getLike(UUID quoteId, UUID userId) {
        Like like = jdbcTemplate.queryForObject(SQL_SELECT, new Object[]{quoteId, userId}, rowMapper);
        if (like != null) {
            return like;
        }
        return null;
    }
}
