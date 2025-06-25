package com.aiinsight.postservice.dto;

import java.util.List;

public class CategoryNewsResponseDto {
    public final CategoryResponseDto category;
    public final List<NewsResponseDto> news;

    public CategoryNewsResponseDto(CategoryResponseDto category, List<NewsResponseDto> news) {
        this.category = category;
        this.news = news;
    }
}