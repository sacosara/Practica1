FROM maven:3.8.4-openjdk-8

WORKDIR /app

COPY . /app/worker

# Definir variable entorno archivo propiedades RabbitMQ?
#ENV RABBITMQ_CONFIG_FILE /app/rabbitmq.properties

# Ejecuta el worker al iniciar el contenedor
CMD CMD ["mvn", "spring-boot:run"]