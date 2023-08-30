FROM adoptopenjdk/maven-openjdk11

COPY target/brs-admin-service-1.0.0.jar app.jar

EXPOSE 8081:8081

RUN apt-get update
RUN apt-get install -y gcc
RUN apt-get install -y curl

ENTRYPOINT ["java","-jar","app.jar"]