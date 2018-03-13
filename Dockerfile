FROM openjdk:8
EXPOSE 8082
#install Spring Boot artifact
VOLUME /tmp
ADD /target/spring-cinema-0.0.1-SNAPSHOT.jar spring-cinema-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /spring-cinema-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-cinema-0.0.1-SNAPSHOT.jar"]