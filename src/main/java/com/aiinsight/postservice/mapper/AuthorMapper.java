package com.aiinsight.postservice.mapper;

import com.aiinsight.postservice.dto.AuthorResponseDto;
import com.aiinsight.postservice.model.Author;

public class AuthorMapper {
    public static AuthorResponseDto toDto(Author author) {
        if (author == null) {
            return null;
        }
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setUrl(author.getUrl());
        return dto;
    }
}