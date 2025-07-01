package com.aiinsight.postservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        // This will apply the corsConfigurationSource bean
        .cors(withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/admin/**").authenticated()
            .anyRequest().permitAll()
        )
        .httpBasic(withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    return http.build();
  }

  /**
   * Defines the CORS configuration for the application.
   * This bean is automatically picked up by the .cors(withDefaults()) in the securityFilterChain.
   * @return CorsConfigurationSource
   */
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();

    // Specify the allowed origins. Use your frontend's URL in production.
    // Using "*" is fine for development but less secure.
    configuration.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:4200", "http://your-frontend-domain.com","http://localhost:3001"));

    // Specify the allowed HTTP methods
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));

    // Specify the allowed headers
    configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Auth-Token"));

    // Allow credentials (e.g., cookies, authorization headers)
    configuration.setAllowCredentials(true);

    // Apply the CORS configuration to all paths
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;
  }
}
