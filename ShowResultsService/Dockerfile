FROM openjdk:17
WORKDIR /app
COPY target/ShowResultsService-0.0.1-SNAPSHOT.jar /app/app.jar
COPY wait-for-it.sh /usr/wait-for-it.sh
RUN chmod +x /usr/wait-for-it.sh
EXPOSE 8090
ENTRYPOINT ["/usr/wait-for-it.sh", "calculate:8086", "--", "java", "-jar", "app.jar"]
