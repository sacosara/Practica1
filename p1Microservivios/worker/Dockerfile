FROM maven:4.0.0-openjdk-8

WORKDIR /app

COPY . /app/worker

RUN mvn clean install -U

FROM openjdk:8
COPY --from=build /home/app/target/worker-0.0.1-SNAPSHOT.jar /usr/local/lib/worker.jar

EXPOSE 8085
# Ejecuta el worker al iniciar el contenedor
#CMD?
ENTRYPOINT ["java", "-jar", "/app/worker.jar"]
