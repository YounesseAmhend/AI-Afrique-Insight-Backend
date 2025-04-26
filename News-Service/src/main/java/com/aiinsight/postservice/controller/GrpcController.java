package com.aiinsight.postservice.controller;

import com.aiinsight.postservice.dto.AddSourceRequest; // Import the DTO
import com.aiinsight.postservice.grpc.PythonScrapingServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // Import PostMapping
import org.springframework.web.bind.annotation.RequestBody; // Import RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import source.SourceProto; // Import SourceProto

@RestController
@RequestMapping("/admin/grpc")
public class GrpcController {

  private final PythonScrapingServiceGrpc pythonScrapingServiceGrpc;

  public GrpcController(PythonScrapingServiceGrpc pythonScrapingServiceGrpc) {
    this.pythonScrapingServiceGrpc = pythonScrapingServiceGrpc;
  }

  @GetMapping("/scrape")
  public String scrapeSources(){
    SourceProto.ScrapeResponse response = pythonScrapingServiceGrpc.scrapeSources();
    return response.getMessage();
  }

  // New endpoint to add a source
  @PostMapping("/sources")
  public String addSource(@RequestBody AddSourceRequest request) {
      SourceProto.SourceResponse response = pythonScrapingServiceGrpc.addSource(
              request.getUrl(),
              request.isContainsAiContent(),
              request.isContainsAfricaContent()
      );
      return response.getMessage();
  }
}