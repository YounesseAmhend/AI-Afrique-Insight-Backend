package com.aiinsight.postservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aiinsight.postservice.dto.AuthorNewsResponseDto;
import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.mapper.AuthorMapper;
import com.aiinsight.postservice.mapper.NewsMapper;
import com.aiinsight.postservice.model.Author;
import com.aiinsight.postservice.repository.AuthorRepository;
import com.aiinsight.postservice.repository.NewsRepository;

@Service
public class AuthorService {

    final private AuthorRepository authorRepository;
    private final NewsRepository newsRepository;

    public AuthorService(AuthorRepository repository, NewsRepository newsRepository) {
        this.authorRepository = repository;
        this.newsRepository = newsRepository;
    }
   
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public AuthorNewsResponseDto getAuthor(Long id) {
        final List<NewsResponseDto> newsResponse = newsRepository.findAllByAuthorId(id).stream().map(NewsMapper::toDto)
                .map(NewsResponseDto::limit).toList();
        final Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return new AuthorNewsResponseDto(AuthorMapper.toDto(author), newsResponse);        
    }
}
