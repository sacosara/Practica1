FROM openjdk:11-jre-slim

# Directorio de trabajo
WORKDIR /app

# Copiar los archivos del cliente al directorio de trabajo
COPY target/cliente-0.0.1-SNAPSHOT.jar /app/cliente.jar

# Expone el puerto 8080 en el contenedor
EXPOSE 8080

# Inicia la aplicación al inicio del contenedor
ENTRYPOINT ["java", "-jar", "/app/cliente.jar"]