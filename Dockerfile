# Etapa 1: Compilación del proyecto con Maven y JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el descriptor de dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente
COPY src src

# Compilamos el proyecto y generamos el WAR (sin ejecutar tests)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiamos el WAR generado desde la etapa de build
COPY --from=build /app/target/*.war app.war

# Render define la variable de entorno PORT automáticamente
ENV PORT=8080
EXPOSE 8080

# Comando de inicio
CMD ["sh", "-c", "java -jar app.war --server.port=$PORT"]
