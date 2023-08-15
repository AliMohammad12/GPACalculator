FROM openjdk:17
WORKDIR /app
COPY target/GPACalculatorService-0.0.1-SNAPSHOT.jar /app/app.jar
COPY wait-for-it.sh /usr/wait-for-it.sh
RUN chmod +x /usr/wait-for-it.sh
EXPOSE 8080
ENTRYPOINT ["/usr/wait-for-it.sh", "authentication:8082", "--", "java", "-jar", "app.jar"]
