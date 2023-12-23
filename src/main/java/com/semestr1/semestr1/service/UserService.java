package com.semestr1.semestr1.service;

import com.semestr1.semestr1.exception.CanNotCreateUserException;
import org.mapstruct.factory.Mappers;

import com.semestr1.semestr1.dto.UserRequest;
import com.semestr1.semestr1.dto.UserResponse;
import com.semestr1.semestr1.mapper.UserMapper;
import com.semestr1.semestr1.model.User;
import com.semestr1.semestr1.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class UserService {
    private UserRepository userRepository;
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID create(UserRequest userRequest) throws CanNotCreateUserException {
        User user = mapper.toEntity(userRequest);
        return userRepository.create(user);
    }
}
