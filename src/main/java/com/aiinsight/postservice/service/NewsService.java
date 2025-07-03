package com.aiinsight.postservice.service;

import java.util.List;
import java.util.Locale;

import com.aiinsight.postservice.dto.PagedResponse;
import com.aiinsight.postservice.model.Cateogory;
import com.aiinsight.postservice.repository.CateogoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.mapper.NewsMapper;
import com.aiinsight.postservice.model.News;
import com.aiinsight.postservice.repository.NewsRepository;

import jakarta.transaction.Transactional;

@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final CateogoryRepository cateogoryRepository;

    public NewsService(NewsRepository postRepository, CateogoryRepository cateogoryRepository) {
        this.newsRepository = postRepository;
        this.cateogoryRepository = cateogoryRepository;
    }

    public List<NewsResponseDto> findAll() {
        final List<News> newsList = newsRepository.findAllByOrderByPostDateDesc();
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

    public PagedResponse<NewsResponseDto> findAll(Pageable pageable, Long categoryId) {
        Page<News> newsPage;

        if (categoryId != null) {
            Cateogory cateogory = cateogoryRepository.findById(categoryId)
                    .orElseThrow();
            newsPage = newsRepository.findByCateogory(cateogory, pageable);
        } else {
            newsPage = newsRepository.findAllByOrderByPostDateDesc(pageable);
        }

        List<NewsResponseDto> newsDtos = newsPage.getContent().stream()
                // Use the static method directly on the class
                .map(NewsMapper::toDto)
                .map(NewsResponseDto::limit)
                .toList();

        return new PagedResponse<>(
                newsDtos,
                newsPage.getNumber(),
                newsPage.getTotalPages(),
                newsPage.getTotalElements(),
                newsPage.isLast());
    }

}
