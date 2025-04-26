package com.aiinsight.postservice.controller;

import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
  private final NewsService postService;
  public PostController(NewsService postService) {
    this.postService = postService;
  }

  @GetMapping
  public ResponseEntity<List<NewsResponseDto>> getAllPosts(){
    List<NewsResponseDto> news = postService.findAll();
    return ResponseEntity.ok().body(news);
  }

//  @PostMapping
//  public ResponseEntity<NewsResponseDto> AddPost(@Valid @RequestBody PostRequestDto postRequestDto){
//    NewsResponseDto newsResponseDto= postService.addPost(postRequestDto);
//    return ResponseEntity.ok().body(newsResponseDto);
//  }

}
