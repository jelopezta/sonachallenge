# Sonatype take home assignment  
Transform an integer into words

### Compile project  
Make sure to have an available jdk 1.8 or higher installation on your machine.  
Execute the following maven command:  
`mvn clean verify`


### Start embedded tomcat with deployed application
Execute the following maven command:  
`mvn tomcat7:run`    
  
The tomcat port can be modified directly in the pom.xml


### Access main page
http://localhost:9065/sonatypechallenge/index.html

### Url for internal get service
http://localhost:9065/sonatypechallenge/rest/englishconverter/{number}

### Future proposed enhancements
*   Integration testing closer to the end user using tools like Cucumber or Fitnesse
*   Security layer to access service
*   Separate presentation layer from application layer further, packaging the actual converter as a separate jar and using it as a dependency
