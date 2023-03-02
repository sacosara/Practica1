FROM openjdk:8-jdk-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos necesarios
COPY target/worker.jar /app/worker.jar
COPY rabbitmq.properties /app/rabbitmq.properties

# Instala los paquetes necesarios
RUN apk add --no-cache bash

# Define la variable de entorno para el archivo de propiedades de RabbitMQ
ENV RABBITMQ_CONFIG_FILE /app/rabbitmq.properties

# Ejecuta el worker al iniciar el contenedor
CMD ["java", "-jar", "/app/worker.jar"]