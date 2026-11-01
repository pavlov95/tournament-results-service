FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B

FROM eclipse-temurin:17-jre

WORKDIR /app

RUN groupadd --system appgroup \
    && useradd --system --gid appgroup --home-dir /app appuser

COPY --from=build --chown=appuser:appgroup \
    /app/target/*.jar app.jar

ENV SERVER_PORT=8081

EXPOSE 8081

USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]
