# Use an official Java 8 runtime as a parent image
FROM openjdk:8-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages specified in pom.xml
RUN apt-get update && \
    apt-get install -y maven && \
    mvn package

# Expose the port that the service will be listening on
EXPOSE 50051

# Define the command to run the service when the container starts
CMD [ "java", "-jar", "./target/grpc-server.jar" ]