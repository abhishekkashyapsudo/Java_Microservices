FROM java:8-jdk
RUN mkdir /app
COPY target/customers.jar /app
WORKDIR /app
EXPOSE 10001
ENTRYPOINT ["java", "-jar", "customers.jar"]
