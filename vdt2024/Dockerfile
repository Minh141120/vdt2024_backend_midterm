# Stage 1: Build the application
FROM gradle:7.5.1-jdk17 as builder

# Set the working directory
WORKDIR /home/gradle/project

# Copy only necessary files to leverage Docker layer caching
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# Copy the source code
COPY src ./src

# Copy gradle wrapper files
COPY gradlew ./

# Build the application without running tests
RUN ./gradlew build --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file from the builder stage
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
