package com.aiinsight.postservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "sources")
@Getter
@Setter
public class Source {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // For PostgreSQL SERIAL
  private Long id;

  @Column(unique = true,  columnDefinition = "TEXT") // TEXT mapping
  private String url;

  @Column(columnDefinition = "jsonb") // Map to String, assuming manual/converter handling for JSON
  private String selector; // Store JSON as String; consider AttributeConverter for real mapping

  private Boolean triggerAfrica; // Use Boolean wrapper class

  private Boolean triggerAi; // Use Boolean wrapper class

  @Column( updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @Temporal(TemporalType.TIMESTAMP)
  private OffsetDateTime createdAt;

  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @Temporal(TemporalType.TIMESTAMP)
  private OffsetDateTime updatedAt;

  // Optional: Inverse side of the relationship if needed
  // @OneToMany(mappedBy = "source", cascade = CascadeType.ALL, orphanRemoval = true)
  // private Set<News> newsArticles;

  // --- Getters and Setters ---
  @PrePersist
  protected void onCreate() {
    if (createdAt == null) { // Set creation timestamp only if not already set
      createdAt = OffsetDateTime.now();
    }
    // Consider setting trigger defaults here if needed and not handled by DB
    if (triggerAfrica == null) triggerAfrica = false; // Example default
    if (triggerAi == null) triggerAi = false;       // Example default
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = OffsetDateTime.now();
  }

}
