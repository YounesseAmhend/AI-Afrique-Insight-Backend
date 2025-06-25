package com.aiinsight.postservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiinsight.postservice.dto.AddSourceRequest; 
import com.aiinsight.postservice.grpc.PythonScrapingServiceGrpc;
import com.aiinsight.postservice.model.Source;
import com.aiinsight.postservice.service.SourceService;

import source.SourceProto; 

@RestController
@RequestMapping("/admin")
public class ScrapingController {

  private final PythonScrapingServiceGrpc pythonScrapingServiceGrpc;

  private final SourceService sourceService;

  public ScrapingController(PythonScrapingServiceGrpc pythonScrapingServiceGrpc, SourceService sourceService) {
    this.pythonScrapingServiceGrpc = pythonScrapingServiceGrpc;
    this.sourceService = sourceService;

  }

  @GetMapping("/scrape")
  public String scrapeSources() {
    SourceProto.ScrapeResponse response = pythonScrapingServiceGrpc.scrapeSources();
    return response.getMessage();
  }

  @PostMapping("/source")
  public String addSource(@RequestBody AddSourceRequest request) {
    SourceProto.SourceResponse response = pythonScrapingServiceGrpc.addSource(
        request.getUrl(),
        request.isContainsAiContent(),
        request.isContainsAfricaContent());
    return response.getMessage();
  }
  
  @GetMapping("/source")
  ResponseEntity<List<Source>> getSources() {
    return ResponseEntity.ok(sourceService.getSources());
  }

}