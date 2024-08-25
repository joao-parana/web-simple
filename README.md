# web-simple


```bash
curl -O "https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.93/bin/apache-tomcat-9.0.93.tar.gz"
tar -xf apache-tomcat-9.0.93.tar.gz
mv apache-tomcat-9.0.93 tomcat
rm apache-tomcat-9.0.93.tar.gz
rm tomcat/webapps/docs
rm tomcat/webapps/examples
# rm tomcat/webapps/host-manager
# rm tomcat/webapps/manager
cd deploy
# Update Tomcat configuration
cp -r * ../tomcat/
cd ..
mvn clean compile package
mkdir -p tomcat/webapps/myapp
cd tomcat/webapps/myapp
jar -xf ../../../target/myapp.war
cd ../../..
# Durante o processo de desenvolvimento e teste pode ser necessário atualizar
# o arquivo web.xml no diretório tomcat/webapps/myapp/WEB-INF
cp src/main/webapp/WEB-INF/web.xml tomcat/webapps/myapp/WEB-INF/
# O redeploy da aplicação pode ser feito sem a necessidade de reiniciar o Tomcat. Use o
# comando abaixo para atualizar o arquivo web.xml e reiniciar o contexto da aplicação
touch tomcat/webapps/myapp/WEB-INF/web.xml
tomcat/bin/catalina.sh run
```

