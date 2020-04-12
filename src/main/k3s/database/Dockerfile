FROM adoptopenjdk/openjdk11:latest

ENV RELEASE_DATE 2019-10-14
ENV H2DATA /h2-data

RUN apt-get update && apt-get install -y unzip
RUN curl http://www.h2database.com/h2-$RELEASE_DATE.zip -o h2.zip \
&& unzip h2.zip -d . \
&& rm h2.zip

RUN ln -s $(ls /h2/bin/*jar) /h2/bin/h2.jar

VOLUME /h2-data

EXPOSE 8082 9092

CMD ["java", "-jar", "/h2/bin/h2.jar", "-web", "-webAllowOthers", "-tcp", "-tcpAllowOthers", "-baseDir", "$H2DATA"]