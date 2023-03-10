
FROM maven:4.0.0-jdk-8 AS build

WORKDIR /app

COPY . /app/externalService

RUN mvn -f /app/externalService/pom.xml clean package
RUN apt-get update && apt-get install -y maven && mvn package

FROM openjdk:8
COPY --from=build /home/app/target/externalservice-0.0.1-SNAPSHOT.jar /usr/local/lib/externalservice.jar
EXPOSE 50051
ENTRYPOINT [ "java", "-jar", "./target/grpc-server.jar" ]