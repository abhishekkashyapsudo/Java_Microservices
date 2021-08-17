FROM java:8-jdk
RUN mkdir /app
COPY target/discovery.jar /app
WORKDIR /app
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "discovery.jar"]
