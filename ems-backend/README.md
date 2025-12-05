# Employee Management System – Spring Boot (PostgreSQL)

`ems-backend` is a RESTful Employee Management System built with Java and Spring Boot. It exposes clean CRUD APIs for managing employees and departments, uses PostgreSQL as the database, and follows a layered architecture with DTOs, services, repositories, and global exception handling.

---

## 🚀 Features

- Create, update, delete, and fetch employees
- Optional departments/roles (if implemented)
- RESTful JSON APIs
- DTO-based request/response models
- Controller → Service → Repository layered design
- PostgreSQL persistence using Spring Data JPA
- Centralized exception handling with consistent error responses

---

## 📁 Project Structure

```text
ems-backend/
├── src/
│   ├── main/
│   │   ├── java/com/akash/ems/
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── service/          # Business logic
│   │   │   ├── repository/       # Spring Data JPA repositories
│   │   │   ├── entity/           # JPA entities (Employee, Department, etc.)
│   │   │   ├── dto/              # Request/response DTOs (if used)
│   │   │   ├── exception/        # Custom exceptions + global handler
│   │   │   └── EmsBackendApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
├── pom.xml
├── README.md
└── .gitignore
```

If your base package is different (for example `com.akash.emsbackend`), update the path above to match it.

---

## 🧩 Error Response Format

All errors are returned in a unified structure similar to:

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

## ⚙️ PostgreSQL Configuration (`src/main/resources/application.properties`)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/emsdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Optional: pretty-print SQL
spring.jpa.properties.hibernate.format_sql=true
```

Steps:

1. Create the database:

   ```sql
   CREATE DATABASE emsdb;
   ```

2. Replace `yourpassword` with your actual PostgreSQL password.

If you’re using environment variables instead of hardcoding credentials, replace the values with `${}` placeholders and configure them in your run configuration or OS environment.

---

## ▶️ Running the Application

From the project root:

```bash
mvn spring-boot:run
```

By default the app will start at:

```text
http://localhost:8080
```

---

## 📌 Example REST Endpoints

Adjust according to your actual controller mappings. Common patterns:

| Method | Endpoint               | Description                |
|--------|------------------------|----------------------------|
| POST   | /api/employees         | Create a new employee      |
| GET    | /api/employees         | Get all employees          |
| GET    | /api/employees/{id}    | Get employee by ID         |
| PUT    | /api/employees/{id}    | Update an existing employee|
| DELETE | /api/employees/{id}    | Delete an employee         |

If you have departments/roles:

| Method | Endpoint                | Description                     |
|--------|-------------------------|---------------------------------|
| GET    | /api/departments        | Get all departments             |
| POST   | /api/departments        | Create a new department         |

Update these tables to match your actual endpoints.

---

## 🧱 Architecture Overview

- **Controller Layer** – Handles HTTP requests and returns responses.
- **DTO Layer** – API-facing models; prevents exposing entity internals directly.
- **Service Layer** – Business logic, validation, transaction boundaries.
- **Repository Layer** – Database access via Spring Data JPA.
- **Entity Layer** – JPA-mapped domain models stored in PostgreSQL.
- **Exception Layer** – Centralized error handling (e.g., `@ControllerAdvice`).

---

## 📜 Version Control

- Clean `.gitignore` (no `target/`, `.idea/`, or `*.iml` files in Git)
- Meaningful commit messages
- Branches can be used for new features or bug fixes

---

## 📄 License

Open-source. You can reuse this backend for learning, demos, or portfolio projects.
