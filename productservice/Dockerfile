FROM amazoncorretto:17.0.6-al2023-headless
ADD target/productservice-0.0.1-SNAPSHOT.jar productservice.jar
ENTRYPOINT ["java", "-jar", "productservice.jar"]