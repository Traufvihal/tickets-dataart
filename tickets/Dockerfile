FROM adoptopenjdk/openjdk11:alpine-slim
ARG JAR_FILE=target/*.jar
ARG PROF='-Dspring.profiles.active=postgres'
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=postgres","/app.jar"]