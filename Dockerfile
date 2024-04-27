# Stage 1: Build Stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . /app
RUN mvn clean install -DskipTests

# Stage 2: Final Stage
FROM openjdk:19-alpine
WORKDIR /app
COPY --from=build /app/target/UserMicroservice-0.0.1-SNAPSHOT.jar /app/UserMicroservice.jar
EXPOSE 9094
ENTRYPOINT ["java", "-jar", "UserMicroservice.jar"]
