package com.semestr1.service;

import com.semestr1.model.Comment;
import com.semestr1.repository.CommentRepository;
import com.semestr1.repository.QuoteRepository;

import java.util.List;
import java.util.UUID;

public class CommentService {
    private CommentRepository commentRepository = new CommentRepository();

    public List<Comment> getCommentsByQuoteId(UUID uuid) {
        return commentRepository.getCommentsByQuoteId(uuid);
    }
}
