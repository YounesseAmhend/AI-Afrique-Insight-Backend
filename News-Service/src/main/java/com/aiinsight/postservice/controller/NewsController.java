package com.aiinsight.postservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiinsight.postservice.dto.NewsRequestDto;
import com.aiinsight.postservice.dto.NewsResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService postService;

    public NewsController(NewsService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<NewsResponseDto>> getAllNewss() {
        List<NewsResponseDto> posts = postService.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @PostMapping
    public ResponseEntity<NewsResponseDto> AddNews(@Valid @RequestBody NewsRequestDto postRequestDto) {
        NewsResponseDto postResponseDto = postService.addNews(postRequestDto);
        return ResponseEntity.ok().body(postResponseDto);
    }
}
