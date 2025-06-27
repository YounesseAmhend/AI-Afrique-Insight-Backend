package com.aiinsight.postservice.controller;

import com.aiinsight.postservice.service.CsvExportService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

  @Autowired
  private CsvExportService csvExportService;

  @GetMapping("/download/news.csv")
  public ResponseEntity<byte[]> downloadNewsAsCsv() {

    byte[] csvData = csvExportService.getCsvFile();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("text/csv"));
    headers.setContentDispositionFormData("attachment", "news_export.csv");

    return ResponseEntity
        .ok()
        .headers(headers)
        .body(csvData);
  }
}
