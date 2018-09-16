FROM openjdk:8-jdk-alpine
MAINTAINER orcun.ulgen@gmail.com
VOLUME /tmp
COPY target/magicnumber-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/app.jar"]
EXPOSE 8080