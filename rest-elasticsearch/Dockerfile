FROM eclipse-temurin:17.0.3_7-jdk

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY build/libs/rest-elasticsearch-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8091

ENTRYPOINT java \
    -jar \
    app.jar

