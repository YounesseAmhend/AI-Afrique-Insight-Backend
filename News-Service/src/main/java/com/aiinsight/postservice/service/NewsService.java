package com.aiinsight.postservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aiinsight.postservice.dto.NewsRequestDto;
import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.mapper.NewsMapper;
import com.aiinsight.postservice.model.News;
import com.aiinsight.postservice.repository.NewsRepository;

@Service
public class NewsService {
    private final NewsRepository postRepository;

    public NewsService(NewsRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<NewsResponseDto> findAll() {
        List<News> postList = postRepository.findAll();

        return postList.stream().map(NewsMapper::toDto).toList();
    }

    public NewsResponseDto addNews(NewsRequestDto postRequestDto) {
        News post = postRepository.save(NewsMapper.toModel(postRequestDto));
        return NewsMapper.toDto(post);
    }
}
