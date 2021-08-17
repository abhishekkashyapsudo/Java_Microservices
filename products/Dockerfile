FROM java:8-jdk
RUN mkdir /app
COPY target/products.jar /app
WORKDIR /app
EXPOSE 10003
ENTRYPOINT ["java", "-jar", "products.jar"]
