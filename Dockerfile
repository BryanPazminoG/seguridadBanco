FROM openjdk:21

WORKDIR /app

COPY target/seguridadBquito-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "seguridadBquito-0.0.1-SNAPSHOT.jar"]