# CRUD_Application
This application is a prototype of a Product Managemt System that performs the four basic functions of persistent storage(CREATE, READ, UPDATE &amp; DELETE).

Following are the technologies used \
  a.) Java 8 \
  b.) Spring Boot \
  c.) JPA \
  d.) Maven \
  e.) MySQL \
  f.) Swagger2

## MySQL DB Setup
1.) Install mysql and login as root user from your terminal \
    ```mysql -u root -p``` \
2.) Enter your root password \
3.) Run the db_script.sql (included in the project resources) by executing the following command \
    mysql > ```source {file_path_location}/db_script.sql```

## Project Setup in Eclipse
1.) Clone the project to your local and import it as a Maven project \
2.) Run as Maven build -> clean install \
3.) Run as Maven build -> spring-boot:run (or)\
4.) Install Spring boot plugin and Run as Spring Boot App (Optional)

## Swagger UI
Access the [Swagger UI](http://localhost:8080/swagger-ui.html) using the link http://localhost:8080/swagger-ui.html

![Swagger UI screenshot](https://user-images.githubusercontent.com/15331235/62424767-6317ba00-b6a1-11e9-9cb5-879524dc8ab7.png)

