package com.aiinsight.postservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.mapper.NewsMapper;
import com.aiinsight.postservice.model.News;
import com.aiinsight.postservice.repository.NewsRepository;

import jakarta.transaction.Transactional;

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

    @Transactional
    public NewsResponseDto getNews(Long id) {
        newsRepository.incrementViewsCount(id);
        News news = newsRepository.findById(id).get();
        return NewsMapper.toDto(news);
    }

    public List<NewsResponseDto> findByAuthorId(final Long id) {
        final List<News> news = newsRepository.findAllByAuthorId(id);
        return news.stream().map(NewsMapper::toDto)
                .map(NewsResponseDto::limit) // So we don't just send load of data while we are not going to use it
                .toList();
    }

    public List<NewsResponseDto> findByCategoryId(final Long id) {
        final List<News> news = newsRepository.findAllByCateogoryId(id);
        return news.stream().map(NewsMapper::toDto)
                .map(NewsResponseDto::limit)
                .toList();
    }
    public List<NewsResponseDto> getTrending() {
        List<News> news = newsRepository.findTrendingNewsThisWeek();
        if (news.isEmpty()) {
            news = newsRepository.findTrendingNewsThisMonth();
            if (news.isEmpty()) {
                news = newsRepository.findTrendingNewsThisYear();
            }
        }
        return news.stream()
                .map(NewsMapper::toDto)
                .map(NewsResponseDto::limit)
                .toList();
    }

    // public NewsResponseDto addNews(NewsRequestDto postRequestDto) {
    // News post = newsRepository.save(NewsMapper.toModel(postRequestDto));
    // return NewsMapper.toDto(post);
    // }
}
