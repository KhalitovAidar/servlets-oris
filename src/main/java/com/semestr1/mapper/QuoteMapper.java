package com.semestr1.mapper;

import com.semestr1.dto.quote.QuoteRequest;
import com.semestr1.dto.quote.QuoteResponse;
import com.semestr1.dto.user.UserRequest;
import com.semestr1.dto.user.UserResponse;
import com.semestr1.model.Quote;
import com.semestr1.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface QuoteMapper {
    @Mappings({
            @Mapping(target = "uuid", ignore = true),
            @Mapping(target = "likes", ignore = true),
            @Mapping(target = "dislikes", ignore = true),
            @Mapping(target = "createdTime", ignore = true)
    })
    Quote toEntity(QuoteRequest quoteRequest);


    QuoteResponse toResponse(Quote quote);

//    @Mappings({
//            @Mapping(target = "uuid", ignore = true)
//    })
//    User toEntityFromResponse(UserResponse userResponse);
}