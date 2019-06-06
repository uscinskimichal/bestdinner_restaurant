FROM openjdk:8-jdk-alpine

LABEL maintainer="adriangorski996@gmail.com"

VOLUME /tmp



ADD /builds/adriangorski996/best-dinner-management-system-backend/target/BestDinner-0.0.1-SNAPSHOT.jar BestDinner.jar
ADD src/main/resources src/main/resources

EXPOSE 5000

ENTRYPOINT ["java","-jar","BestDinner.jar"]
