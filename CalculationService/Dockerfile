FROM openjdk:17
WORKDIR /app
COPY target/CalculationService-0.0.1-SNAPSHOT.jar /app/app.jar
COPY wait-for-it.sh /usr/wait-for-it.sh
RUN chmod +x /usr/wait-for-it.sh
EXPOSE 8086
ENTRYPOINT ["/usr/wait-for-it.sh", "mysqldb:3306", "--", "java", "-jar", "app.jar"]
