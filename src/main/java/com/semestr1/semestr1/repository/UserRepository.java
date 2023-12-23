package com.semestr1.semestr1.repository;

import com.semestr1.semestr1.exception.CanNotCreateUserException;
import com.semestr1.semestr1.model.User;
import com.semestr1.semestr1.utils.DatabaseUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Optional;
import java.util.UUID;

public class UserRepository {
    private JdbcTemplate jdbcTemplate = DatabaseUtil.getJdbcTemplate();

    private final static String SQL_CREATE = "insert into account(uuid, name, password) values(?, ?, ?)";

    private final RowMapper<User> rowMapper = (rs, rowNum) -> new User(

    );



    public UUID create(User user) throws CanNotCreateUserException {
        user.setUuid(UUID.randomUUID());

        try {
            jdbcTemplate.update(SQL_CREATE, user.getUuid(), user.getName(), user.getPassword());
            return user.getUuid();
        } catch (DataIntegrityViolationException e) {
            throw new CanNotCreateUserException(e.getMessage());
        }
    }

    public UUID getUser(User user) {

    }
}