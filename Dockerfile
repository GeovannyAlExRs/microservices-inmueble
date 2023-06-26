FROM openjdk:17-jdk-slim
LABEL authors="Geovanny AlEx Rs"
VOLUME /tmp
RUN apt-get update
COPY "./target/microservices-inmueble-0.0.1-SNAPSHOT.jar" "appinmueble.jar"
ENTRYPOINT ["java", "-jar", "appinmueble.jar"]
EXPOSE 8084