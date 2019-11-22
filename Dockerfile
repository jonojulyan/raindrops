FROM amazoncorretto:11
COPY ./build/libs/raindrops-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "raindrops-0.0.1-SNAPSHOT.jar"]