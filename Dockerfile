FROM eclipse-temurin:17.0.10_7-jre-jammy
LABEL authors="kmahadevan"
RUN mkdir /app
COPY target/worker.jar /app/worker.jar
WORKDIR /app
EXPOSE 10020
ENTRYPOINT ["java", "-jar", "worker.jar"]