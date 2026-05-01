FROM maven:3.8.6-openjdk-18 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:18-jdk-slim
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENV POSTGRE_DB_URL=jdbc:postgresql://db_container_name:5432/nome_do_banco

CMD ["java", "-jar", "app.jar"]