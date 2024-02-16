# spring-boot-spanner-postgres-liquibase

spring-boot-spanner-postgres-liquibase is a scaffolding for a spring based web application.
It can be built into a single jar file using Maven.


## Overview and technical features

* One endpoint enabling saving data of some baked goods (flavour).
* Spanner with PostgreSQL Dialect (pgAdapter) database run from a Docker container.
* Database schema is created automatically on the application startup with a Liquibase SQL-based migration.

## Getting Started

To clone this repository, execute the following in the command line:
```bash
$ git clone https://github.com/skumar568/SpringStarterWithGCPSpannerAndLiquibase.git
```

Start the database that will be used by the app.
```bash
$ docker-compose up -d
```

You can build the application and run tests with:
```bash
$ mvn clean install
```


There are a number of different ways to start the application, one such way is to run the following maven command
* `mvn spring-boot:run`

Verify that application is running
* `curl http://localhost:8090/actuator/health`

You can send a request from Postman. Refer to swagger at: http://localhost:8090/swagger-ui/index.html

## Built With

* [Spring Boot 3.2.2](https://start.spring.io/)
* [Maven](https://maven.apache.org/)
* [Spanner Emulator with pgAdaptor](https://cloud.google.com/spanner/docs/emulator)