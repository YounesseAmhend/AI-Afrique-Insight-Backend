package com.aiinsight.postservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true,  columnDefinition = "TEXT")
  private String name;

  @Column(unique = true, columnDefinition = "TEXT")
  private String url;

  @Column( updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @Temporal(TemporalType.TIMESTAMP)
  private OffsetDateTime createdAt;

  // Optional: Inverse side of the relationship if needed
  // @OneToMany(mappedBy = "author") // Cascade might not be desired here
  // private Set<News> newsArticles;

  @PrePersist
  protected void onCreate() {
    if (createdAt == null) {
      createdAt = OffsetDateTime.now();
    }
  }

}
