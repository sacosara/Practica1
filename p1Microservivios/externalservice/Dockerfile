FROM maven:3.8.4-openjdk-8

WORKDIR /app

COPY . /app/externalService

RUN mvn dependency:resolve

EXPOSE 50051

CMD ["mvn", "spring-boot:run"]