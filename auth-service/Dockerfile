# Stage 1: Build the application using Maven and JDK 21 (Temurin)
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies first to leverage Docker cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application JAR, skipping tests
# Using -Dmaven.test.skip=true is another common way to skip tests
RUN mvn clean package -DskipTests

# Stage 2: Create the final, smaller runtime image using JRE on Alpine
# Using eclipse-temurin JRE on Alpine for a much smaller footprint
FROM eclipse-temurin:21-jre-alpine AS runner
# Alternative: FROM openjdk:21-jre-alpine AS runner

WORKDIR /app

# Create a non-root user and group for security
# Use -S for system user/group, -G to assign group
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy only the built JAR from the builder stage
# Ensure correct path from the builder stage's WORKDIR and target directory
COPY --from=builder /app/target/auth-service-0.0.1-SNAPSHOT.jar ./app.jar

# Optional: Change ownership of the app files to the non-root user
# RUN chown appuser:appgroup ./app.jar # Usually not needed if user doesn't need to write

# Switch to the non-root user
USER appuser

EXPOSE 4003

# Run the application using the JRE
ENTRYPOINT ["java", "-jar", "app.jar"]