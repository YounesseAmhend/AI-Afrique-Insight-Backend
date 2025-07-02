package com.aiinsight.postservice.controller;

import com.aiinsight.postservice.dto.AiCompanyDto;
import com.aiinsight.postservice.service.AiCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ai-company")
public class AiCompanyController {
  private final AiCompanyService aiCompanyService;

  public AiCompanyController(AiCompanyService aiCompanyService) {
    this.aiCompanyService = aiCompanyService;
  }

  @PostMapping("/generate")
  public ResponseEntity<List<AiCompanyDto>> generateAndSaveCompanies() {
    List<AiCompanyDto> companies = aiCompanyService.generateAndSaveAiCompanies();
    return ResponseEntity.ok(companies);
  }

  @GetMapping
  public ResponseEntity<List<AiCompanyDto>> getAllCompanies() {
    List<AiCompanyDto> companies = aiCompanyService.getAllCompanies();
    return ResponseEntity.ok(companies);
  }


}
