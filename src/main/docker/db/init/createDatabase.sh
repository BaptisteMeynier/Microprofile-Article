#!/bin/bash

java -jar /h2/bin/h2.jar -tcp -tcpAllowOthers -tcpPort 1521 -baseDir $H2DATA &

java -cp /h2/bin/h2.jar org.h2.tools.RunScript -user $KUMULUZEE_DATASOURCES0_USERNAME -password $KUMULUZEE_DATASOURCES0_PASSWORD -url jdbc:h2:file:/database/h2-data/fish -script /tmp/schema.sql

#java -cp /h2/bin/h2.jar org.h2.tools.Server -tcpShutdown tcp://localhost:1521