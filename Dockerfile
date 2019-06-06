FROM openjdk:8-jdk-alpine

LABEL maintainer="adriangorski996@gmail.com"

VOLUME /tmp

ARG JAR_FILE=/builds/adriangorski996/best-dinner-management-system-backend/target/BestDinner-0.0.1-SNAPSHOT.jar
ARG CONFIG=src/main/resources

# Add the application's jar to the container
ADD ${JAR_FILE} BestDinner.jar
ADD ${CONFIG} src/main/resources

EXPOSE 5000

ENTRYPOINT ["java","-jar","BestDinner.jar"]
