FROM maven:3.9-amazoncorretto-20 AS build

MAINTAINER "Marc Hannappel"

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package



FROM amazoncorretto:20-alpine3.18-jdk as run
COPY --from=build /home/app/target/backend-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]