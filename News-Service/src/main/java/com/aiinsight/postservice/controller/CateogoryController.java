package com.aiinsight.postservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiinsight.postservice.dto.CategoryNewsResponseDto;
import com.aiinsight.postservice.model.Cateogory;
import com.aiinsight.postservice.service.CateogoryService;

@RestController
@RequestMapping("/category")
public class CateogoryController {

    private final CateogoryService cateogoryService;

    public CateogoryController(CateogoryService cateogoryService) {
        this.cateogoryService = cateogoryService;
    }

    @GetMapping
    public ResponseEntity<List<Cateogory>> getCategories() {
        List<Cateogory> categories = cateogoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryNewsResponseDto> getCategory(@PathVariable Long id) {
        final CategoryNewsResponseDto category = cateogoryService.getCategoryWithNews(id);
        return ResponseEntity.ok().body(category);
    }
}