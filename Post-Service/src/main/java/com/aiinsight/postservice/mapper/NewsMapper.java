package com.aiinsight.postservice.mapper;

import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.model.Author;
import com.aiinsight.postservice.model.News;
import com.aiinsight.postservice.model.Source;

public class NewsMapper {

  public static NewsResponseDto toDto(News news) {
    if (news == null) {
      return null;
    }

    NewsResponseDto dto = new NewsResponseDto();

    dto.setId(String.valueOf(news.getId()));
    dto.setTitle(news.getTitle());
    dto.setUrl(news.getUrl());
    dto.setBody(news.getBody()); // Map body
    dto.setPostDate(news.getPostDate());
    dto.setImageUrl(news.getImageUrl());
    dto.setCreatedAt(news.getCreatedAt());

    // Handle Author mapping (check for null)
    Author author = news.getAuthor();
    if (author != null) {
      dto.setAuthorName(author.getName());
    } else {
      dto.setAuthorName(null); // Explicitly set null if no author
    }

    // Handle Source mapping (assuming the source is never null based on News entity @NotNull)
    Source source = news.getSource();
    dto.setSourceUrl(source.getUrl());


    return dto;

  }

  // Removed the toModel method.
  // Creating a News entity requires fetching Source and Author entities
  // based on IDs from NewsRequestDto. This logic belongs in the Service layer,
  // not the mapper. The Service will construct the News object.

  // If you wanted a helper to map *only* the direct fields (title, url, body, etc.)
  // you could have a method like this, but the service would still need to set
  // the Source and Author objects separately after fetching them.
        /*
        public static void updateNewsFromDto(News news, NewsRequestDto dto) {
             news.setTitle(dto.getTitle());
             news.setUrl(dto.getUrl());
             news.setBody(dto.getBody());
             news.setImageUrl(dto.getImageUrl());
             news.setPostDate(dto.getPostDate());
             // NOTE: Setting Source and Author must be done in the service layer
        }
        */

}
