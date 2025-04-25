package com.aiinsight.postservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostRequestDto {
  @NotBlank(message = "Title is required")
  @Size(max = 1000 , message ="Title shouldn't pass 1000 characters" )
  private String title;

  @NotBlank(message = "Content shouldn't be blank")
  private String Content;

  @NotBlank(message = "Author shouldn't be blank")
  private String Author;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return Content;
  }

  public void setContent(String content) {
    Content = content;
  }

  public String getAuthor() {
    return Author;
  }

  public void setAuthor(String author) {
    Author = author;
  }
}
