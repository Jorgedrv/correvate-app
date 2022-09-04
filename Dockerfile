FROM gradle:7.5-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11
VOLUME /tmp
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/correvate-files-ms-1.0.0.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/correvate-files-ms-1.0.0.jar"]