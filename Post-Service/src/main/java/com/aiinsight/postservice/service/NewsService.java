package com.aiinsight.postservice.service;

import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.mapper.NewsMapper;
import com.aiinsight.postservice.model.News;
import com.aiinsight.postservice.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsService {
  private final NewsRepository newsRepository;

  public NewsService(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  @Transactional(readOnly = true) // Use readOnly transaction for query methods
  public List<NewsResponseDto> findAll() {
    List<News> postList = newsRepository.findAll() ;

    return postList.stream().map(NewsMapper::toDto).toList();
  }


// next time we deal with this , aka not that important
//  public NewsResponseDto addPost(PostRequestDto postRequestDto) {
//    News news = newsRepository.save(NewsMapper.toModel(postRequestDto));
//    return NewsMapper.toDto(news);
//  }

//  @Transactional // Good practice for operations involving multiple repository calls/saves
//  public NewsResponseDto addNews(NewsRequestDto newsRequestDto) {
//    // 1. Fetch the mandatory Source entity
//    Source source = sourceRepository.findById(newsRequestDto.getSourceId())
//        .orElseThrow(() -> new EntityNotFoundException("Source not found with id: " + newsRequestDto.getSourceId()));
//
//    // 2. Fetch the optional Author entity only if authorId is provided
//    Author author = null; // Initialize author as null
//    if (newsRequestDto.getAuthorId() != null) {
//      author = authorRepository.findById(newsRequestDto.getAuthorId())
//          .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + newsRequestDto.getAuthorId()));
//    }
//
//    // 3. Create and populate the News entity
//    News news = new News();
//    news.setTitle(newsRequestDto.getTitle());
//    news.setUrl(newsRequestDto.getUrl());
//    news.setBody(newsRequestDto.getBody());
//    news.setImageUrl(newsRequestDto.getImageUrl());
//    news.setPostDate(newsRequestDto.getPostDate());
//
//    // 4. Set the fetched related entities
//    news.setSource(source);
//    if (author != null) {
//      news.setAuthor(author);
//    }
//    // Note: createdAt will be set by @PrePersist callback in the News entity
//
//    // 5. Save the News entity
//    News savedNews = newsRepository.save(news);
//
//    // 6. Map to DTO and return
//    // Ensure relationships are loaded if needed by the mapper (LazyInitializationException check)
//    // Fetching by ID again or using @Transactional ensures the session is active
//    // or EAGER fetch types (though LAZY is generally better).
//    // Since we just saved it, the object 'savedNews' should have the relations loaded
//    // if they were set correctly before saving, especially within a @Transactional method.
//    return NewsMapper.toDto(savedNews);
//  }

}
