package com.aiinsight.postservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ai_companies")
public class AiCompany {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column
  private String logo;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column
  private String funding;

  @Column
  private String region;


  @Column
  private String category;

  @Column(columnDefinition = "TEXT")
  private String growth;


  @Column(columnDefinition = "TEXT")
  private String image;

  @Column
  private String url;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  // Constructors
  public AiCompany() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  // Getters and Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getLogo() { return logo; }
  public void setLogo(String logo) { this.logo = logo; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public String getFunding() { return funding; }
  public void setFunding(String funding) { this.funding = funding; }

  public String getRegion() { return region; }
  public void setRegion(String region) { this.region = region; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public String getGrowth() { return growth; }
  public void setGrowth(String growth) { this.growth = growth; }

  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }

  public LocalDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

  public LocalDateTime getUpdatedAt() { return updatedAt; }
  public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

}
