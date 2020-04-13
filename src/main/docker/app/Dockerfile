FROM adoptopenjdk/openjdk11:latest

RUN mkdir /app

WORKDIR /app

ADD ./target/microprofile-article-1.0.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "microprofile-article-1.0.0-SNAPSHOT.jar"]