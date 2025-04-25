package com.aiinsight.postservice.mapper;

import com.aiinsight.postservice.dto.PostRequestDto;
import com.aiinsight.postservice.dto.PostResponseDto;
import com.aiinsight.postservice.model.Post;

public class PostMapper {

  public static PostResponseDto toDto(Post post) {
    PostResponseDto postRequestDto = new PostResponseDto();

    postRequestDto.setId(post.getId().toString());
    postRequestDto.setTitle(post.getTitle());
    postRequestDto.setContent(post.getContent());
    postRequestDto.setAuthor(post.getAuthor());

    return postRequestDto;
  }

  public static Post toModel(PostRequestDto postRequestDto) {
    Post post = new Post();
    post.setTitle(postRequestDto.getTitle());
    post.setContent(postRequestDto.getContent());
    post.setAuthor(postRequestDto.getAuthor());
    return post;
  }
}
