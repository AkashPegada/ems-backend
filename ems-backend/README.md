# Employee Management System – Spring Boot (PostgreSQL)

`ems-backend` is a RESTful Employee Management System built using Spring Boot and Java.  
The backend provides clean and efficient CRUD APIs for managing employees, structured using a layered architecture (Controller → Service → Repository). PostgreSQL is used as the primary database, with Spring Data JPA handling ORM operations.

---

## 🚀 Features

- Create, update, fetch, and delete employees
- DTO-based request/response models
- Layered, maintainable architecture
- Centralized exception handling with human-readable error responses
- PostgreSQL persistence using Spring Data JPA
- Model mapping via custom mapper classes
- Production-ready structure with modular components

---

## 📁 Project Structure

```text
ems-backend/
├── src/
│   ├── main/
│   │   ├── java/com/akashspring/emsbackend/
│   │   │   ├── controller/        # REST controllers (EmployeeController)
│   │   │   ├── dto/               # Request/response DTOs
│   │   │   ├── entity/            # JPA entities (Employee, etc.)
│   │   │   ├── exception/         # Custom exceptions + global handler
│   │   │   ├── mapper/            # Entity <-> DTO converters
│   │   │   ├── repository/        # Spring Data JPA repositories
│   │   │   └── service/           # Business logic layer
│   │   │
│   │   │   └── EmsBackendApplication.java   # Main Spring Boot application
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
├── pom.xml
├── README.md
└── .gitignore
```

---

## 🧩 Example Error Response

Your global exception handler returns structured JSON like:

```json
{
  "timestamp": "2025-10-23T14:25:31",
  "message": "Employee not found",
  "details": "/api/employees/999",
  "errorCode": "EMPLOYEE_NOT_FOUND"
}
```

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- IntelliJ IDEA

---

## ⚙️ PostgreSQL Configuration (application.properties)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/emsdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

### Database setup:
```sql
CREATE DATABASE emsdb;
```

---

## ▶️ Running the Application

From the project root:

```bash
mvn clean install
mvn spring-boot:run
```

App runs at:

```
http://localhost:8080
```

---

## 📌 Available REST Endpoints

### **Employee APIs**

| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| POST   | /api/employees         | Create a new employee           |
| GET    | /api/employees         | Fetch all employees             |
| GET    | /api/employees/{id}    | Fetch employee by ID            |
| PUT    | /api/employees/{id}    | Update employee details         |
| DELETE | /api/employees/{id}    | Delete an employee              |

Update this section if you have extra modules like departments/roles.

---

## 🧱 Architecture Summary

- **controller** → receives requests, returns JSON
- **dto** → clean API payload definitions
- **entity** → JPA models persisted in PostgreSQL
- **mapper** → converts entity ↔ DTO cleanly
- **service** → business logic and transaction boundaries
- **repository** → Spring Data interfaces for DB operations
- **exception** → centralized error handling across application

---

## 📜 Version Control Practices

- Clean `.gitignore` ensures no `target/`, `.idea/`, or `.iml` files are pushed
- Small, meaningful commits like:
    - `Add Employee entity + repository`
    - `Implement Employee CRUD service`
    - `Add DTO + mapper for Employee`
    - `Add GlobalExceptionHandler`

---

## 📄 License

Open-source. You may use it for learning, interview prep, or portfolio demonstration.
