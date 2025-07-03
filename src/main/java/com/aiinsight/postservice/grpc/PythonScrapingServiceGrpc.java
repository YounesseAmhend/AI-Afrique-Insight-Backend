package com.aiinsight.postservice.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import source.SourceProto;
import source.SourceServiceGrpc;

@Service
public class PythonScrapingServiceGrpc {
  private static final Logger log = LoggerFactory.getLogger(PythonScrapingServiceGrpc.class);
  private final SourceServiceGrpc.SourceServiceBlockingStub blockingStub;


  public PythonScrapingServiceGrpc(
      @Value("${grpc.client.python-scraper.address:0.0.0.0}") String address , // Updated property name for clarity
      @Value("${grpc.client.python-scraper.port:3015}") int port // Updated property name for clarity
  ) {
    log.info("Connecting to gRPC server at {}:{}", address, port);

    ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port)
                                                  .usePlaintext() // Use plaintext for simplicity, consider TLS in production
                                                  .build();

    blockingStub = SourceServiceGrpc.newBlockingStub(channel);
  }

  /**
   * Calls the addSource gRPC method on the Python service.
   *
   * @param url The URL of the source to add.
   * @param containsAiContent Whether the source may contain AI content.
   * @param containsAfricaContent Whether the source may contain Africa content.
   * @return The response from the gRPC service.
   */
  public SourceProto.SourceResponse addSource(String url, boolean containsAiContent, boolean containsAfricaContent) {
    log.info("Calling addSource gRPC method for URL: {}", url);
    SourceProto.SourceRequest request = SourceProto.SourceRequest.newBuilder()
            .setUrl(url)
            .setContainsAiContent(containsAiContent)
            .setContainsAfricaContent(containsAfricaContent)
            .build();
    try {
      SourceProto.SourceResponse response = blockingStub.addSource(request);
      log.info("Received response from addSource: {}", response.getMessage());
      return response;
    } catch (Exception e) {
      log.error("gRPC call to addSource failed for URL {}: {}", url, e.getMessage(), e);
      // Consider throwing a custom exception or returning a specific error response
      return SourceProto.SourceResponse.newBuilder()
              .setMessage("Error calling addSource: " + e.getMessage())
              .build();
    }
  }

  /**
   * Calls the scrape gRPC method on the Python service.
   *
   * @return The response from the gRPC service.
   */
  public SourceProto.ScrapeResponse scrapeSources() {
      log.info("Calling scrape gRPC method.");
      SourceProto.ScrapeRequest request = SourceProto.ScrapeRequest.newBuilder().build();
      try {
          SourceProto.ScrapeResponse response = blockingStub.scrape(request);
          log.info("Received response from scrape: {}", response.getMessage());
          return response;
      } catch (Exception e) {
          log.error("gRPC call to scrape failed: {}", e.getMessage(), e);
          // Consider throwing a custom exception or returning a specific error response
          return SourceProto.ScrapeResponse.newBuilder()
                  .setMessage("Error calling scrape: " + e.getMessage())
                  .build();
      }
  }

  // Consider adding a shutdown method for the channel when the application stops
  // For example, using @PreDestroy
  // public void shutdown() {
  //   channel.shutdown();
  // }
}