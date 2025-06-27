package com.aiinsight.postservice.mapper;

import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.model.News;

public class NewsMapper {

    public static NewsResponseDto toDto(News news) {
        NewsResponseDto postRequestDto = new NewsResponseDto();

        postRequestDto.setId(news.getId().toString());
        postRequestDto.setTitle(news.getTitle());
        postRequestDto.setBody(news.getBody());
        postRequestDto.setViewsCount(news.getViewsCount());
        postRequestDto.setUrl(news.getUrl());
        postRequestDto.setImageUrl(news.getImageUrl());

        if (news.getCateogory() != null) {
            postRequestDto.setCategory(CategoryMapper.toDto(news.getCateogory()));
        } else {
            postRequestDto.setCategory(null);
        }

        postRequestDto.setAuthor(AuthorMapper.toDto(news.getAuthor()));

        postRequestDto.setCreatedAt(news.getCreatedAt());
        postRequestDto.setPostDate(news.getPostDate());

        return postRequestDto;
    }

    // public static News toModel(NewsRequestDto postRequestDto) {
    // News news = new News();
    // news.setTitle(postRequestDto.getTitle());
    // news.setBody(postRequestDto.getBody());
    // news.setUrl(postRequestDto.getUrl());
    // news.setImageUrl(postRequestDto.getImageUrl());
    // news.setAuthor(null); // TODO if We ever need it
    // news.setSourceId(postRequestDto.getSourceId());
    // return news;
    // }
}
