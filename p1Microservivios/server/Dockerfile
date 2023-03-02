# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file to the container
COPY target/myapp-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Install RabbitMQ libraries
RUN apk add --no-cache bash curl
RUN echo "http://dl-cdn.alpinelinux.org/alpine/edge/community" >> /etc/apk/repositories
RUN apk add --no-cache rabbitmq-c rabbitmq-c-dev

# Expose the application port and the WebSocket port
EXPOSE 8080 9090

# Set the environment variables for RabbitMQ
ENV SPRING_RABBITMQ_HOST=localhost
ENV SPRING_RABBITMQ_PORT=5672
ENV SPRING_RABBITMQ_USERNAME=myusername
ENV SPRING_RABBITMQ_PASSWORD=mypassword

# Run the application when the container starts
CMD ["java", "-jar", "myapp.jar"]