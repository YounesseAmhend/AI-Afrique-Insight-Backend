# Stage 1: Build the application using Maven and JDK 21 (Temurin)
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies first to leverage Docker cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application JAR, explicitly skipping tests (recommended for Docker builds)
RUN mvn clean package -DskipTests
# Note: Added -DskipTests. Tests are usually run in CI, not during image build.

# Stage 2: Create the final, smaller runtime image using JRE on Alpine
FROM eclipse-temurin:21-jre-alpine AS runner
# Alternative: FROM openjdk:21-jre-alpine AS runner

WORKDIR /app

# Create a non-root user and group for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy only the built JAR from the builder stage
# Ensure the JAR name matches your project's output
COPY --from=builder /app/target/api-gateway-0.0.1-SNAPSHOT.jar ./app.jar

# Switch to the non-root user
USER appuser

# Expose the correct port for the API Gateway
EXPOSE 4004

# Run the application using the JRE
ENTRYPOINT ["java", "-jar", "app.jar"]