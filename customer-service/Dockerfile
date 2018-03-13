FROM openjdk
MAINTAINER tcs tsg <tcs.tsg@gmail.com>
ADD target/customer-service.jar customer-service.jar
ENTRYPOINT ["java", "-jar", "/customer-service.jar"]
EXPOSE 3333