FROM openjdk:17
ADD target/dockerMJ-final.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
