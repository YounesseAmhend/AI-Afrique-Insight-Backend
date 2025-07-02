package com.aiinsight.postservice.dto;

public class AiCompanyDto {
  private String name;
  private String logo;
  private String description;
  private String funding;
  private String region;
  private String category;
  private String growth;
  private String url;

  // Constructors
  public AiCompanyDto() {}

  public AiCompanyDto(String name, String logo, String description, String funding,
                      String region, String category, String growth, String url) {
    this.name = name;
    this.logo = logo;
    this.description = description;
    this.funding = funding;
    this.region = region;
    this.category = category;
    this.growth = growth;
    this.url = url;
  }

  // Getters and Setters
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

}
