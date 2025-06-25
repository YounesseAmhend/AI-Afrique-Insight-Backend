package com.aiinsight.postservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aiinsight.postservice.dto.CategoryNewsResponseDto;
import com.aiinsight.postservice.dto.CategoryResponseDto;
import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.mapper.CategoryMapper;
import com.aiinsight.postservice.model.Cateogory;
import com.aiinsight.postservice.repository.CateogoryRepository;

@Service
public class CateogoryService {
    private final CateogoryRepository cateogoryRepository;
    private final NewsService newsService;

    public CateogoryService(CateogoryRepository cateogoryRepository, NewsService newsService) {
        this.cateogoryRepository = cateogoryRepository;
        this.newsService = newsService;
    }

    public List<Cateogory> getCategories() {
        return cateogoryRepository.findAll();
    }

    public Optional<Cateogory> getCategory(Long id) {
        return cateogoryRepository.findById(id);
    }

    public CategoryNewsResponseDto getCategoryWithNews(Long id) {
        final List<NewsResponseDto> newsResponse = newsService.findByCategoryId(id);
        final Cateogory cateogory = cateogoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        CategoryResponseDto categoryDto = CategoryMapper.toDto(cateogory);
        return new CategoryNewsResponseDto(categoryDto, newsResponse);
    }
}