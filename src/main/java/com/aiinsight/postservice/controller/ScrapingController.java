package com.aiinsight.postservice.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiinsight.postservice.dto.AddSourceRequest;
import com.aiinsight.postservice.grpc.PythonScrapingServiceGrpc;
import com.aiinsight.postservice.model.Source;
import com.aiinsight.postservice.service.SourceService;

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
  public ResponseEntity<String> scrapeSources() {
    try {
      // Start async operation and return immediate response
      new Thread(() -> {
        try {
          pythonScrapingServiceGrpc.scrapeSources();
        } catch (Exception e) {
          // Log the error for backend monitoring
          System.err.println("Scraping failed: " + e.getMessage());
        }
      }).start();

      return ResponseEntity.accepted().body("Scraping process started. This may take several minutes.");
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Failed to initiate scraping: " + e.getMessage());
    }
  }

  @PostMapping("/source")
  public ResponseEntity<String> addSource(@RequestBody AddSourceRequest request) {
    // Check if source already exists
    boolean sourceExists = sourceService.sourceExists(request.getUrl());
    if (sourceExists) {
      return ResponseEntity.badRequest().body("Source already exists");
    }

    // Create a CompletableFuture to handle the async operation
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
      try {
        pythonScrapingServiceGrpc.addSource(
            request.getUrl(),
            request.isContainsAiContent(),
            request.isContainsAfricaContent());
      } catch (Exception e) {
        // Wrap the error in a RuntimeException to propagate it
        throw new RuntimeException("Failed to add source: " + e.getMessage());
      }
    });

    // Handle the future in the main thread
    try {
      future.get(5, TimeUnit.SECONDS); // Wait for 3 seconds
      return ResponseEntity.accepted().body("Source addition process started. This may take several minutes.");
    } catch (ExecutionException | TimeoutException | InterruptedException e) {
      return ResponseEntity.accepted().body("Source addition process started. This may take several minutes.");
    }

  }

  @GetMapping("/source")
  ResponseEntity<List<Source>> getSources() {
    List<Source> sources = sourceService.getSources();

    return ResponseEntity.ok(sources);
  }

  @PatchMapping("/source/{id}")
  public ResponseEntity<?> updateSourceUrl(@PathVariable Long id, @RequestBody AddSourceRequest request) {
    try {
      Source updatedSource = sourceService.updateSourceUrl(id, request);
      return ResponseEntity.ok(updatedSource);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.notFound().build();
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Failed to update source: " + e.getMessage());
    }
  }

  @DeleteMapping("/source/{id}")
  public ResponseEntity<?> deleteSource(@PathVariable Long id) {
    try {
      sourceService.deleteSource(id);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Failed to delete source: " + e.getMessage());
    }
  }

}