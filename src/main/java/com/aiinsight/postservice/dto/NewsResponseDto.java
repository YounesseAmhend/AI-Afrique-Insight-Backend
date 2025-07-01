package com.aiinsight.postservice.dto;

import java.time.Instant;

public class NewsResponseDto {
    private String id;
    private String title;
    private String body;
    private CategoryResponseDto category;
    private String url;
    private Long viewCount;
    private String imageUrl;
    private AuthorResponseDto author;
    private Instant createdAt;
    private Instant postDate;

    // Just to save bandwith only use this for list of news
    public NewsResponseDto limit() {
        if (this.body != null) {
            this.body = body.substring(0, Math.min(500, body.length()));
        }
        this.author = null;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AuthorResponseDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorResponseDto author) {
        this.author = author;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getPostDate() {
        return postDate;
    }

    public void setPostDate(Instant postDate) {
        this.postDate = postDate;
    }

    public CategoryResponseDto getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDto category) {
        this.category = category;
    }

    public Long getViewsCount() {
        return viewCount;
    }

    public void setViewsCount(Long viewCount) {
        this.viewCount = viewCount;
    }


}
