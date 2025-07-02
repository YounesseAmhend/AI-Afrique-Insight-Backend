package com.aiinsight.postservice.service;

import com.aiinsight.postservice.dto.AiCompanyDto;
import com.aiinsight.postservice.model.AiCompany;
import com.aiinsight.postservice.repository.AiCompanyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.google.genai.Client;
import com.google.genai.ResponseStream;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AiCompanyService {

  private final AiCompanyRepository aiCompanyRepository;
  private final ObjectMapper objectMapper;
  private final Client client = new Client();


  public AiCompanyService(AiCompanyRepository aiCompanyRepository) {
    this.aiCompanyRepository = aiCompanyRepository;
    this.objectMapper = new ObjectMapper();
  }


  public List<AiCompanyDto> getAllCompanies() {
    return aiCompanyRepository.findAllOrderByCreatedAtDesc()
        .stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }




  @Transactional
  public List<AiCompanyDto> generateAndSaveAiCompanies() {
    GenerateContentResponse response = client.models.generateContent(
        "gemini-2.5-flash",
        """
            lease generate a JSON array of AI companies with the following exact structure for each company:
            {
                "name": "Company Name",
                "logo": "/placeholder.svg?height=80&width=80",
                "description": "Brief description of what the company does in AI",
                "funding": "Funding information or market cap",
                "region": "north-america, europe, asia, or other",
                "category": "AI category like 'AI Hardware & Infrastructure', 'Machine Learning', 'Computer Vision', etc.",
                "growth": "Growth description",
                "url": "/companies/company-name-slug"
            }
            
            Generate 10 companies per region. Return only a valid JSON array, with no additional text or markdown.
            Make sure the region is one of: north-america, europe, asia, other.
            Make sure the logo follows the pattern: /placeholder.svg?height=80&width=80.
            Make sure the url follows the pattern: /companies/company-name-in-lowercase-with-dashes.
            """,
        null
    );


    // CORRECT: Use the .text() helper method from the provided source
    String jsonText = response.text();

    // It's good practice to check for a null response
    if (jsonText == null) {
      // Handle the case where the response was empty or had no text
      // For example, throw an exception or return an empty list
      throw new RuntimeException("Received an empty text response from the AI.");
    }

    List<AiCompany> companies = parseAndSaveCompanies(jsonText);

    return companies.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }

  public List<AiCompanyDto> getAllAiCompanies() {
    return aiCompanyRepository.findAllOrderByCreatedAtDesc()
        .stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }

  private List<AiCompany> parseAndSaveCompanies(String jsonResponse) {
    try {
      // Clean the response to extract JSON
      String cleanJson = extractJsonFromResponse(jsonResponse);

      JsonNode jsonArray = objectMapper.readTree(cleanJson);

      List<AiCompany> companies = new java.util.ArrayList<>();

      for (JsonNode companyNode : jsonArray) {
        AiCompany company = new AiCompany();
        company.setName(companyNode.get("name").asText());
        company.setLogo(companyNode.get("logo").asText());
        company.setDescription(companyNode.get("description").asText());
        company.setFunding(companyNode.get("funding").asText());
        company.setRegion(companyNode.get("region").asText());
        company.setCategory(companyNode.get("category").asText());
        company.setGrowth(companyNode.get("growth").asText());
        company.setUrl(companyNode.get("url").asText());

        companies.add(company);
      }

      return aiCompanyRepository.saveAll(companies);

    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed to parse AI response: " + e.getMessage(), e);
    }
  }

  private String extractJsonFromResponse(String response) {
    String cleaned = response.trim();

    // Find JSON array start and end
    int startIndex = cleaned.indexOf('[');
    int endIndex = cleaned.lastIndexOf(']') + 1;

    if (startIndex != -1 && endIndex > startIndex) {
      return cleaned.substring(startIndex, endIndex);
    }

    return cleaned; // Fallback to returning the cleaned string
  }

  private AiCompanyDto convertToDto(AiCompany company) {
    return new AiCompanyDto(
        company.getName(),
        company.getLogo(),
        company.getDescription(),
        company.getFunding(),
        company.getRegion(),
        company.getCategory(),
        company.getGrowth(),
        company.getUrl()
    );
  }
}