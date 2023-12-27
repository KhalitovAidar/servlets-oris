package com.semestr1.repository;

import com.semestr1.model.Comment;
import com.semestr1.model.Quote;
import com.semestr1.utils.DatabaseUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CommentRepository {
    private JdbcTemplate jdbcTemplate = DatabaseUtil.getJdbcTemplate();
    private final String SQL_GET_COMMENTS_BY_QUOTE = "select * from comments where quote_id = ?";

    private final RowMapper<Comment> rowMapper = (rs, rowNum) -> {
        Comment comment = new Comment();

        comment.setUuid((UUID) rs.getObject("uuid"));
        comment.setText(rs.getString("text"));
        comment.setQuote((UUID) rs.getObject("quote_id"));
        comment.setUser((UUID) rs.getObject("author_id"));

        return comment;
    };
    public List<Comment> getCommentsByQuoteId(UUID uuid) {
        return jdbcTemplate.query(SQL_GET_COMMENTS_BY_QUOTE, new Object[]{uuid}, rowMapper);
    }
}
