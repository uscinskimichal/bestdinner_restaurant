FROM openjdk:8-jdk-alpine

LABEL maintainer="adriangorski996@gmail.com"

VOLUME /tmp

EXPOSE 5000

ARG JAR_FILE=./target/BestDinner-0.0.1-SNAPSHOT.jar
ARG CONFIG=./src/main/resources

# Add the application's jar to the container
ADD ${JAR_FILE} BestDinner.jar
ADD ${CONFIG} src/main/resources


# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/BestDinner.jar"]
