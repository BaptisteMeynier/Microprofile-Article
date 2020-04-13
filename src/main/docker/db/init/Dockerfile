FROM adoptopenjdk/openjdk11:latest

ENV RELEASE_DATE 2019-10-14
ENV H2DATA /database/h2-data

RUN apt-get update && apt-get install -y unzip
RUN curl http://www.h2database.com/h2-$RELEASE_DATE.zip -o h2.zip \
&& unzip h2.zip -d . \
&& rm h2.zip

RUN ln -s $(ls /h2/bin/*jar) /h2/bin/h2.jar

EXPOSE 1521

#VOLUME /database

ADD ./src/main/docker/db/scripts/schema.sql /tmp
ADD ./src/main/docker/db/scripts/data.sql /tmp

RUN java -jar /h2/bin/h2.jar -tcp -tcpAllowOthers -tcpPort 1521 -baseDir $H2DATA &

RUN java -cp /h2/bin/h2.jar org.h2.tools.RunScript -user sa -url jdbc:h2:file:/database/h2-data/fish -script /tmp/schema.sql
#RUN java -cp /h2/bin/h2.jar org.h2.tools.RunScript -user sa -url jdbc:h2:file:/database/h2-data/fish -script /tmp/data.sql