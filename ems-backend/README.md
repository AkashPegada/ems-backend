# Employee Management System (Spring Boot + PostgreSQL)

A RESTful backend built with **Spring Boot** and **PostgreSQL** implementing complete CRUD operations.

## Features
- Create, Read, Update, Delete employee records
- DTO + Mapper layers
- Exception handling (`ResourceNotFoundException`)
- Layered architecture (Controller → Service → Repository)
- PostgreSQL integration with JPA & Hibernate

## Run Locally
1. Copy `src/main/resources/application-example.properties` → `application.properties`
2. Fill your PostgreSQL credentials.
3. Run `EmsBackendApplication.java`.
4. Access endpoints: `http://localhost:8080/api/employees`

## Tech Stack
- Java 17
- Spring Boot 3
- PostgreSQL
- Maven
- Lombok

## Project Structure
