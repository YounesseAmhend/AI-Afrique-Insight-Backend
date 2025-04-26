package com.aiinsight.postservice.dto;

import lombok.Getter;
import lombok.Setter;

// A simple DTO to represent the request body for adding a source
@Setter
@Getter
public class AddSourceRequest {
  // Getters and setters are needed for Spring to map the JSON body
  private String url;
    private boolean containsAiContent;
    private boolean containsAfricaContent;
}