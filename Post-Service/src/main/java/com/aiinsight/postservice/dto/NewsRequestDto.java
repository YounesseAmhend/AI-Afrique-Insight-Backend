package com.aiinsight.postservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.OffsetDateTime;

@Setter
@Getter
public class NewsRequestDto {
  @NotNull(message = "Source ID is required")
  private Long sourceId; // ID of the Source entity

  @NotBlank(message = "Title is required")
  @Size(max = 1000, message = "Title shouldn't exceed 1000 characters")
  private String title;

  @NotBlank(message = "URL is required")
  @URL(message = "Must be a valid URL")
  private String url;

  // Optional: ID of the Author entity. Client might send null or the ID.
  private Long authorId;

  // Changed from 'Content' to 'body' to match News entity
  @NotBlank(message = "Body (content) shouldn't be blank")
  private String body;

  // Optional fields
  private OffsetDateTime postDate;

  @URL(message = "Image URL must be a valid URL if provided")
  private String imageUrl;

//  there should be a bit of thinking in this cause when adding to the news we need source id and author id but
//  for a normal user he will ne be adding a source and author id so we need to fix that or handle it at least or add
//  an endpoint for adding news without source and author id
}
