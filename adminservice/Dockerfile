FROM java:8-jdk
RUN mkdir /app
COPY target/adminservice.jar /app
WORKDIR /app
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "adminservice.jar"]
