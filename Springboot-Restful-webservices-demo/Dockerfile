#https://hub.docker.com/_/openjdk java deprecated so we are using eclipse
FROM eclipse-temurin

LABEL maintainer="dineshasd333@gmail.com"

#Container working Dir
WORKDIR /app

COPY target/springboot-restful-webservices-demo-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar

ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]