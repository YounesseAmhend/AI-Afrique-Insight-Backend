package com.aiinsight.postservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiinsight.postservice.dto.AuthorNewsResponseDto;
import com.aiinsight.postservice.model.Author;
import com.aiinsight.postservice.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAuthors() {
        List<Author> authors = authorService.getAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorNewsResponseDto> getAuthor(@PathVariable Long id) {
        final AuthorNewsResponseDto author = authorService.getAuthor(id);
        return ResponseEntity.ok().body(author);
    }

}
