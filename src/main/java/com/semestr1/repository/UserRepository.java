package com.semestr1.repository;

import com.semestr1.exception.user.CanNotCreateUserException;
import com.semestr1.model.User;
import com.semestr1.exception.user.UserNotFoundException;
import com.semestr1.utils.DatabaseUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.UUID;

public class UserRepository {
    private JdbcTemplate jdbcTemplate = DatabaseUtil.getJdbcTemplate();

    private final static String SQL_CREATE = "insert into account(uuid, name, password) values(?, ?, ?)";
    private final static String SQL_GET_USER = "select * from account where name = ? and password = ?";
    private final static String SQL_GET_BY_ID = "select * from account where uuid = ?";
    private final static String SQL_DELETE_USER = "delete from account where name = ?";

    private final RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUuid((UUID) rs.getObject("uuid"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        return user;
    };



    public UUID create(User user) throws CanNotCreateUserException {
        user.setUuid(UUID.randomUUID());

        try {
            jdbcTemplate.update(SQL_CREATE, user.getUuid(), user.getName(), user.getPassword());
            return user.getUuid();
        } catch (DataIntegrityViolationException e) {
            throw new CanNotCreateUserException(e.getMessage());
        }
    }

    public User getUser(User user) throws UserNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_USER, new Object[]{user.getName(), user.getPassword()}, rowMapper);
        }
        catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException("Пользователь с заданными именем и паролем не существует!");
        }
    }

    public User getById(UUID id) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void delete(String name) {
        jdbcTemplate.update(SQL_DELETE_USER, name);
    }
}