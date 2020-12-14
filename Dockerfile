# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="alberto.ah14@hotmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 5025

# The application's jar file
ARG JAR_FILE=target/SpringBootJwtAuthentication-0.0.1.jar

# Add the application's jar to the container
ADD ${JAR_FILE} SpringBootJwtAuthentication-0.0.1.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/SpringBootJwtAuthentication-0.0.1.jar"]

# docker build
# sudo docker build -t alberto21/resapi-imc .

# docker run
# sudo docker run --name RESTAPI-IMC -p 5025:8080 -d alberto21/resapi-imc
