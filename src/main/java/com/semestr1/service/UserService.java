package com.semestr1.service;

import com.semestr1.dto.user.UserRequest;
import com.semestr1.exception.user.CanNotCreateUserException;
import com.semestr1.exception.user.UserNotFoundException;
import com.semestr1.mapper.UserMapper;
import com.semestr1.model.User;
import com.semestr1.repository.UserRepository;
import org.mapstruct.control.MappingControl;
import org.mapstruct.factory.Mappers;

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

    public User getUser(UserRequest userRequest) throws UserNotFoundException {
        User user = mapper.toEntity(userRequest);
        return userRepository.getUser(user);
    }

    public void delete(UserRequest userRequest) {
        User user = mapper.toEntity(userRequest);
        userRepository.delete(user.getName());
    }
}
