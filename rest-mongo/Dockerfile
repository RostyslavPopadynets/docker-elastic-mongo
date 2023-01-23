FROM eclipse-temurin:17.0.3_7-jdk

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY build/libs/rest-mongo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090

ENTRYPOINT java \
    $JAVA_OPTS \
    -jar \
    app.jar
