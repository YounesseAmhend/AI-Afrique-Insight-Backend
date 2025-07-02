package com.aiinsight.postservice.scheduler;

import com.aiinsight.postservice.service.AiCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AiCompanyScheduler {
  private static final Logger logger = LoggerFactory.getLogger(AiCompanyScheduler.class);

  private final AiCompanyService aiCompanyService;

  public AiCompanyScheduler(AiCompanyService aiCompanyService) {
    this.aiCompanyService = aiCompanyService;
  }

// this is if you want it to run on every startup
//  @EventListener(ApplicationReadyEvent.class)
//  public void generateCompaniesOnStartup() {
//    logger.info("Starting AI company generation on application startup...");
//    try {
//      aiCompanyService.generateAndSaveAiCompanies();
//      logger.info("AI company generation completed successfully on startup");
//    } catch (Exception e) {
//      logger.error("Error during AI company generation on startup: {}", e.getMessage(), e);
//    }
//  }

  /**
   * Runs AI company generation every week (Sunday at midnight)
   * Cron expression: "0 0 0 * * SUN" means:
   * - 0 seconds
   * - 0 minutes
   * - 0 hours (midnight)
   * - every day of month
   * - every month
   * - Sunday
   */
  @Scheduled(cron = "0 0 0 * * SUN")
  public void generateCompaniesWeekly() {
    logger.info("Starting weekly AI company generation...");
    try {
      aiCompanyService.generateAndSaveAiCompanies();
      logger.info("Weekly AI company generation completed successfully");
    } catch (Exception e) {
      logger.error("Error during weekly AI company generation: {}", e.getMessage(), e);
    }
  }

  /**
   * Alternative method: runs every 7 days from application start
   * You can use this instead of the cron-based method if preferred
   */
  // @Scheduled(fixedRate = 7 * 24 * 60 * 60 * 1000) // 7 days in milliseconds
  public void generateCompaniesEverySevenDays() {
    logger.info("Starting AI company generation (every 7 days)...");
    try {
      aiCompanyService.generateAndSaveAiCompanies();
      logger.info("AI company generation (every 7 days) completed successfully");
    } catch (Exception e) {
      logger.error("Error during AI company generation (every 7 days): {}", e.getMessage(), e);
    }
  }

}
