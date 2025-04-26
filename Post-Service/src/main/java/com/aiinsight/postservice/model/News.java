package com.aiinsight.postservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "news")
@Getter
@Setter
public class News {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY) // LAZY is often preferred for performance
  @JoinColumn(name = "sourceId") // Maps to the sourceId foreign key column
  private Source source;

  @Column(columnDefinition = "TEXT")
  private String title;

  @Column(unique = true , columnDefinition = "TEXT")
  private String url;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "authorId", nullable = true) // Maps to the authorId foreign key column (nullable)
  private Author author;

  @Lob // Use @Lob for potentially large TEXT fields
  @Column( columnDefinition = "TEXT")
  private String body;

  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @Temporal(TemporalType.TIMESTAMP)
  private OffsetDateTime postDate;

  @Column(columnDefinition = "TEXT")
  private String imageUrl;


  private OffsetDateTime createdAt;

  // --- Getters and Setters ---

  @PrePersist
  protected void onCreate() {
    if (createdAt == null) {
      createdAt = OffsetDateTime.now();
    }
  }

}
