# Sonatype take home assignment  
Transform an integer into words

### Compile project
`mvn clean verify`


### Start embedded tomcat with deployed application
`mvn tomcat7:run`    

  The tomcat port can be modified directly in the pom.xml


### Access main page
http://localhost:9065/sonatypechallenge/index.html

### Url for internal rest service
http://localhost:9065/sonatypechallenge/rest/englishconverter/{number}
