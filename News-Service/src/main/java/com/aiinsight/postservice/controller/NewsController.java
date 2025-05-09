package com.aiinsight.postservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiinsight.postservice.dto.NewsRequestDto;
import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.service.NewsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/news")
public class NewsController {

	private final NewsService newsService;

	public NewsController(final NewsService newService) {
		this.newsService = newService;
	}

	@GetMapping
	public ResponseEntity<List<NewsResponseDto>> getAllNews() {
		final List<NewsResponseDto> posts = newsService.findAll();
		return ResponseEntity.ok().body(posts);
	}

	@PostMapping
	public ResponseEntity<NewsResponseDto> AddNews(@Valid @RequestBody NewsRequestDto postRequestDto) {
		NewsResponseDto postResponseDto = newsService.addNews(postRequestDto);
		return ResponseEntity.ok().body(postResponseDto);
	}
}
