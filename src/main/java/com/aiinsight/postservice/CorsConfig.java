package com.aiinsight.postservice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "http://77.37.124.70:3013", "http://srv844192.hstgr.cloud:3013")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true); // allow credentials;
            }
        };
    }
}
