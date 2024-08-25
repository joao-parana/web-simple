#!/bin/bash

cd tomcat/webapps/myapp
jar -xf ../../../target/myapp.war
cd ../../..
tomcat/bin/catalina.sh run

