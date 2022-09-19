FROM ubuntu:latest
RUN apt update -y && apt install -y default-jre && && rm -rf /var/lib/apt/lists/*
COPY ./target/java-api-0.0.1-SNAPSHOT.jar java-api-v1.jar
#RUN rm -rf /var/cache/apt/archives /var/lib/apt/lists/*
#RUN apt clean
EXPOSE 8080
ENV company dtn
CMD java -jar java-api-v1.jar



#FROM openjdk:8-jdk-alpine
#FROM openjdk:8-jre-alpine
#RUN addgroup -S demo && adduser -S demo -G demo
#USER demo

#ENTRYPOINT ["java", "-jar", "/app.jar"]

#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar

#FROM eclipse-temurin:17-jdk-alpine
#RUN addgroup demogroup; adduser  --ingroup demogroup --disabled-password demo
#USER demo
#WORKDIR /app
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline
#COPY src ./src
#CMD ["./mvnw", "spring-boot:run"]