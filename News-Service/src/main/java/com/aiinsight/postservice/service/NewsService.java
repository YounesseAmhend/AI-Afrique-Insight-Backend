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
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository postRepository) {
        this.newsRepository = postRepository;
    }

    public List<NewsResponseDto> findAll() {
        final List<News> newsList = newsRepository.findAll();
        return newsList.stream()
                .map(NewsMapper::toDto)
                .map(NewsResponseDto::limit) // So we don't just send load of data while we are not going to use it

                .toList();
    }

    public NewsResponseDto getNews(Long id) {
        News news = newsRepository.findById(id).get();
        return NewsMapper.toDto(news);
    }

    public List<NewsResponseDto> findByAuthorId(final Long id) {
        final List<News> news = newsRepository.findAllByAuthorId(id);
        return news.stream().map(NewsMapper::toDto)
                .map(NewsResponseDto::limit) // So we don't just send load of data while we are not going to use it
                .toList();
    }

    public NewsResponseDto addNews(NewsRequestDto postRequestDto) {
        News post = newsRepository.save(NewsMapper.toModel(postRequestDto));
        return NewsMapper.toDto(post);
    }
}
