FROM maven:3.9.11-amazoncorretto-21-alpine as Build

WORKDIR app/

COPY pom.xml  .

RUN mvn dependency:go-offline -B

COPY ./src ./src

RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY --from=Build /app/target/*.war app.war

EXPOSE 3333

ENTRYPOINT ["java", "-jar", "app.war"]