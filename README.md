# Introduction

This is project is about building the backend application that uses the spring data JPA in multiple relational databases. In this context, we will connect to SQL Server and MySql databases. Read more in this link :  
[SpringBoot with spring data JPA using multi-data source databases MySql + SQLServer](https://medium.com/@sopheamak/springboot-with-spring-data-jpa-using-multi-data-source-databases-mysql-sqlserver-3ce5f69559)

# Technologies

- springboot 2
- spring data jpa
- databases (mysql + sqlserver)
- lombok

# Before running this project

- install JAVA JDK 1.8.x to up
- install Docker Engine for databases
- Eclipse / IDEA / STS / ohter tools

# Install Database using Docker

- install SQL Server DB using docker mode

```
    docker run --name sqlserver1  -e 'ACCEPT_EULA=Y' -e 'MSSQL_SA_PASSWORD=jEe8BUkAta32sA' -e 'MSSQL_PID=Enterprise' -p 1433:1433 -d microsoft/mssql-server-linux

    #create first database name: jpa_test
    
   docker exec -it sqlserver1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'jEe8BUkAta32sA' -Q "CREATE DATABASE jpa_test"
```


- run database Mysql with docker
````
docker run --name  mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql:5.7
````
#### create database only first time 
```
docker exec -it mysql bash
mysql -uroot -ppassword -h127.0.0.1
create database jpa  CHARACTER SET utf8 COLLATE utf8_general_ci;


```

# REST APIs


````
# create a new category

curl -X POST \
  http://localhost:8080/api/category \
  -H 'content-type: application/json' \
  -d '{"name":"category1","description":"description1"}'

#create a new country

curl -X POST \
  http://localhost:8080/api/country \
  -H 'content-type: application/json' \
  -d '{ "name":"camboida", "isoCode":"kh"}'


#get all data

curl -X GET http://localhost:8080/api/all


{
"country":[{"id":1,"name":"camboida","isoCode":"kh"}],
"category":[{"id":1,"name":"category1","description":"description1"}]
}

````
