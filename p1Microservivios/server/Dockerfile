# Use an official OpenJDK runtime as a parent image
FROM maven:3.8.4-openjdk-8

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file to the container
COPY . /app/server

# Install RabbitMQ libraries
RUN apk add --no-cache bash curl
RUN echo "http://dl-cdn.alpinelinux.org/alpine/edge/community" >> /etc/apk/repositories
RUN apk add --no-cache rabbitmq-c rabbitmq-c-dev

EXPOSE 8081 9090

# Set the environment variables for RabbitMQ
ENV SPRING_RABBITMQ_HOST=localhost
ENV SPRING_RABBITMQ_PORT=5672
ENV SPRING_RABBITMQ_USERNAME=myusername
ENV SPRING_RABBITMQ_PASSWORD=mypassword

CMD CMD ["mvn", "spring-boot:run"]