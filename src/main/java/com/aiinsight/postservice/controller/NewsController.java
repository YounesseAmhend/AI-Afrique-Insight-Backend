package com.aiinsight.postservice.controller;

import java.util.List;

import com.aiinsight.postservice.dto.PagedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.service.NewsService;

@RestController
@RequestMapping("/news")
//@CrossOrigin(origins = "*") // Allows all origins
public class NewsController {

	private final NewsService newsService;

	public NewsController(final NewsService newService) {
		this.newsService = newService;
	}

	@GetMapping
	public ResponseEntity<PagedResponse<NewsResponseDto>> getAllNews(Pageable pageable , @RequestParam(required = false) Long categoryId) {
		final PagedResponse<NewsResponseDto> posts = newsService.findAll(pageable , categoryId);
		return ResponseEntity.ok(posts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NewsResponseDto> getNews(@PathVariable Long id) {
		final NewsResponseDto post = newsService.getNews(id);
		return ResponseEntity.ok().body(post);
	}

	@GetMapping("/trending")
	public ResponseEntity<List<NewsResponseDto>> getTrendingNews() {
		final List<NewsResponseDto> trendingNews = newsService.getTrending();
		return ResponseEntity.ok().body(trendingNews);
	}

	// @PostMapping
	// public ResponseEntity<NewsResponseDto> AddNews(@Valid @RequestBody
	// NewsRequestDto postRequestDto) {
	// NewsResponseDto postResponseDto = newsService.addNews(postRequestDto);
	// return ResponseEntity.ok().body(postResponseDto);
	// }
}
