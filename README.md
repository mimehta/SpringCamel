# ATMService built by using Springboot and Camel
Background

Rest service to locate ATMs in the Netherlands.

How to use
Rest service is secured by uusing the basic authentication.

Please use credentials: Username: minesh Password: password1

http://host:port/api/atms - retrives full list of ATMs 

http://host:port/api/atms/city/{city} - retrives list of ATMs located in city.

Technical details

This application is built using Maven, Java, Spring Boot, Spring Security, Apache Camel.

Build application

mvn clean package

Execution of application

mvn spring-boot:run

