package com.aiinsight.postservice.mapper;

import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.dto.NewsRequestDto;
import com.aiinsight.postservice.model.News;

public class NewsMapper {

    public static NewsResponseDto toDto(News post) {
        NewsResponseDto postRequestDto = new NewsResponseDto();

        postRequestDto.setId(post.getId().toString());
        postRequestDto.setTitle(post.getTitle());
        postRequestDto.setBody(post.getBody());
        postRequestDto.setUrl(post.getUrl());
        postRequestDto.setImageUrl(post.getImageUrl());
        postRequestDto.setAuthor(post.getAuthor() != null ? post.getAuthor().getName() : null);
        postRequestDto.setCreatedAt(post.getCreatedAt());
        postRequestDto.setPostDate(post.getPostDate());

        return postRequestDto;
    }

    public static News toModel(NewsRequestDto postRequestDto) {
        News post = new News();
        post.setTitle(postRequestDto.getTitle());
        post.setBody(postRequestDto.getBody());
        post.setUrl(postRequestDto.getUrl());
        post.setImageUrl(postRequestDto.getImageUrl());
        post.setSourceId(postRequestDto.getSourceId());
        return post;
    }
}
