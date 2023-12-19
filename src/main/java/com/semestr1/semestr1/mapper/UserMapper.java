package com.semestr1.semestr1.mapper;

import com.semestr1.semestr1.dto.UserRequest;
import com.semestr1.semestr1.dto.UserResponse;
import com.semestr1.semestr1.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {
    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "quotes", ignore = true)
    })
    User toEntity(UserRequest userRequest);

    UserResponse toResponse(User userEntity);

    @Mappings({
            @Mapping(target = "uuid", ignore = true)
    })
    User toEntityFromResponse(UserResponse userResponse);
}