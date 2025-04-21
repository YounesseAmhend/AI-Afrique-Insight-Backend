package com.aiinsight.postservice.controller;

import com.aiinsight.postservice.grpc.PythonScrapingServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grpc")
public class GrpcController {

  private final PythonScrapingServiceGrpc pythonScrapingServiceGrpc;

  public GrpcController(PythonScrapingServiceGrpc pythonScrapingServiceGrpc) {
    this.pythonScrapingServiceGrpc = pythonScrapingServiceGrpc;
  }

  @GetMapping("/scrape")
  public String scrapeSources(){
    return pythonScrapingServiceGrpc.scrapeSources().getMessage();
  }
}
