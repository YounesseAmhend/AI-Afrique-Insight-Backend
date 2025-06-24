package com.aiinsight.postservice.dto;

import java.util.List;

import com.aiinsight.postservice.model.Author;

public class AuthorResponseDto {
    public final Author author;
    public final List<NewsResponseDto> news;
    
    public AuthorResponseDto(Author author, List<NewsResponseDto> news) {
        this.author = author;
        this.news = news;
    }
}
