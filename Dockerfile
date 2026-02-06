FROM maven:3.9.11-amazoncorretto-21-alpine as Build

WORKDIR app/

COPY pom.xml  .

RUN --mount=type=cache,target=/root/.m2 \
    mvn dependency:go-offline -B --no-transfer-progress

COPY ./src ./src

RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests -q


FROM eclipse-temurin:21-alpine

WORKDIR /app

ARG USERNAME=userapp
ARG USER_UID=1000
ARG USER_GID=$USER_UID

COPY --from=Build /app/target/*.war app.war

RUN addgroup -g $USER_GID $USERNAME \
    && adduser -D -u $USER_UID -G $USERNAME $USERNAME

RUN chown -R $USERNAME:$USERNAME /app

USER $USERNAME

EXPOSE 3333

ENTRYPOINT ["java", "-jar", "app.war"]