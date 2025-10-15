
# Run the app
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .

RUN mvn -B dependency:go-offline -B

COPY src ./src
RUN mvn -B -f pom.xml -DskipTests package

FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app/app.jar"]
