package com.aiinsight.postservice.dto;

import java.util.List;


public class AuthorNewsResponseDto {
    public final AuthorResponseDto author;
    public final List<NewsResponseDto> news;
    
    public AuthorNewsResponseDto(AuthorResponseDto author, List<NewsResponseDto> news) {
        this.author = author;
        this.news = news;
    }
}
