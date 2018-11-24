FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/users.jar target/users.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","target/users.jar"]
