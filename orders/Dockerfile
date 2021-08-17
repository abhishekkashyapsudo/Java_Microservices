FROM java:8-jdk
RUN mkdir /app
COPY target/orders.jar /app
WORKDIR /app
EXPOSE 10002
ENTRYPOINT ["java", "-jar", "orders.jar"]
