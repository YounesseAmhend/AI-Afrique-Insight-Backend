package com.aiinsight.postservice.dto;

import java.util.List;

public class PagedResponse<T> {
  private List<T> content;
  private int number;          // Current page number
  private int totalPages;      // Total pages available
  private long totalElements;  // Total items across all pages
  private boolean last;        // Is this the last page?

  // Constructor to easily map from a Page object
  public PagedResponse(List<T> content, int number, int totalPages, long totalElements, boolean last) {
    this.content = content;
    this.number = number;
    this.totalPages = totalPages;
    this.totalElements = totalElements;
    this.last = last;
  }

  public boolean isLast() {
    return last;
  }

  public void setLast(boolean last) {
    this.last = last;
  }

  public long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(long totalElements) {
    this.totalElements = totalElements;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }
}