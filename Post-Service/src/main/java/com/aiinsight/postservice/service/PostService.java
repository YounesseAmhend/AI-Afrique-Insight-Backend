package com.aiinsight.postservice.service;

import com.aiinsight.postservice.dto.PostRequestDto;
import com.aiinsight.postservice.dto.PostResponseDto;
import com.aiinsight.postservice.mapper.PostMapper;
import com.aiinsight.postservice.model.Post;
import com.aiinsight.postservice.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<PostResponseDto> findAll() {
    List<Post> postList = postRepository.findAll() ;

    return postList.stream().map(PostMapper::toDto).toList();
  }

  public PostResponseDto addPost(PostRequestDto postRequestDto) {
    Post post = postRepository.save(PostMapper.toModel(postRequestDto));
    return PostMapper.toDto(post);
  }
}
