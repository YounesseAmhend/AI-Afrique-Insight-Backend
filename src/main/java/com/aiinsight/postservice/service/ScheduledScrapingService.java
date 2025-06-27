
package com.aiinsight.postservice.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.aiinsight.postservice.grpc.PythonScrapingServiceGrpc;

@Service
public class ScheduledScrapingService {

    private final PythonScrapingServiceGrpc pythonScrapingServiceGrpc;

    public ScheduledScrapingService(PythonScrapingServiceGrpc pythonScrapingServiceGrpc) {
        this.pythonScrapingServiceGrpc = pythonScrapingServiceGrpc;
    }

    // Scheduled to run every day at 2 AM
    @Scheduled(cron = "0 0 2 * * *", zone = "Africa/Casablanca")
    public void performScheduledScraping() {
        try {
            System.out.println("Running scheduled scraping...");
            pythonScrapingServiceGrpc.scrapeSources();
        } catch (Exception e) {
            System.err.println("Scheduled scraping failed: " + e.getMessage());
        }
    }
}