FROM maven:4.0.0-openjdk-8 AS Build

WORKDIR /app
COPY . /app/server
COPY target/server-0.0.1-SNAPSHOT.jar /app/server.jar

# Install RabbitMQ libraries
RUN apk add --no-cache bash curl
RUN echo "http://dl-cdn.alpinelinux.org/alpine/edge/community" >> /etc/apk/repositories
RUN apk add --no-cache rabbitmq-c rabbitmq-c-dev
RUN mvn -f /app/server/pom.xml clean package


# Set the environment variables for RabbitMQ
ENV SPRING_RABBITMQ_HOST=localhost
ENV SPRING_RABBITMQ_PORT=5672
ENV SPRING_RABBITMQ_USERNAME=myusername
ENV SPRING_RABBITMQ_PASSWORD=mypassword

FROM openjdk:8
COPY --from=build /home/app/target/server-0.0.1-SNAPSHOT.jar /usr/local/lib/server.jar
# Application port and WebSocket port
EXPOSE 8081 9090
CMD ["java", "-jar", "myapp.jar"]