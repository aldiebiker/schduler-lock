FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/scheduler-0.0.1-SNAPSHOT.jar /home/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/app.jar"]