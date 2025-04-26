package com.aiinsight.postservice.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class NewsResponseDto {
  private String id; // Use Long to match the entity's ID type
  private String title;
  private String url;
  private String body; // Changed from content
  private String authorName; // Get the name from the Author entity
  private String sourceUrl;  // Get the URL from the Source entity
  private OffsetDateTime postDate;
  private String imageUrl;
  private OffsetDateTime createdAt;
}
