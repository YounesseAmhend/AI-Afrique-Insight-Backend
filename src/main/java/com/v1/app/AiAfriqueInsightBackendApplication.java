package com.v1.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class that serves as the entry point for the Spring Boot application.
 * This annotation enables auto-configuration, component scanning, and configuration properties
 * scanning for the application. It combines three annotations:
 * - @Configuration: Marks the class as a source of bean definitions
 * - @EnableAutoConfiguration: Enables Spring Boot's auto-configuration
 * mechanism
 * - @ComponentScan: Enables component scanning within the package and its
 * sub-packages
 */
@SpringBootApplication
public class AiAfriqueInsightBackendApplication {

  /**
    * Main method that starts the Spring Boot application.
    *
    * @param args command line arguments passed to the application
  */
  public static void main(final String[] args) {
    SpringApplication.run(AiAfriqueInsightBackendApplication.class, args);
  }

}
