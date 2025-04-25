package com.aiinsight.postservice.controller;

import com.aiinsight.postservice.dto.PostRequestDto;
import com.aiinsight.postservice.dto.PostResponseDto;
import com.aiinsight.postservice.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
  private final PostService postService;
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public ResponseEntity<List<PostResponseDto>> getAllPosts(){
    List<PostResponseDto> posts = postService.findAll();
    return ResponseEntity.ok().body(posts);
  }

  @PostMapping
  public ResponseEntity<PostResponseDto> AddPost(@Valid @RequestBody PostRequestDto postRequestDto){
    PostResponseDto postResponseDto= postService.addPost(postRequestDto);
    return ResponseEntity.ok().body(postResponseDto);
  }
}
