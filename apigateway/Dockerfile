FROM java:8-jdk
RUN mkdir /app
COPY target/apigateway.jar /app
WORKDIR /app
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "apigateway.jar"]
