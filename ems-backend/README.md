# Employee Management System – Spring Boot (PostgreSQL)

`ems-backend` is a RESTful Employee Management System built with Java and Spring Boot. It exposes clean CRUD APIs for managing employees (and optionally departments/roles), persists data in PostgreSQL, and follows a layered architecture with DTOs, services, repositories, and centralized exception handling.

---

## 🚀 Features

- Create, update, fetch, and delete employees
- Optional departments/roles mapping (adapt based on your implementation)
- RESTful JSON APIs following standard HTTP methods
- DTO-based request/response models to decouple API and entities
- Layered architecture: Controller → Service → Repository → Database
- PostgreSQL persistence with Spring Data JPA
- Global error handling and consistent error responses

---

## 📁 Project Structure

```text
ems-backend/
├── src/
│   ├── main/
│   │   ├── java/com/akash/ems/
│   │   │   ├── controller/       # REST controllers (Employee, Department, etc.)
│   │   │   ├── service/          # Business logic + validation
│   │   │   ├── repository/       # Spring Data JPA repositories
│   │   │   ├── entity/           # JPA entities (Employee, Department, Role...)
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

Update the package path above if your base package differs.

---

## 🧩 Error Response Format

Typical error response returned by the global exception handler:

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

## ⚙️ PostgreSQL Configuration

`src/main/resources/application.properties` (adapt the values you actually use):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/emsdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

Database creation:

```sql
CREATE DATABASE emsdb;
```

You can also switch to environment variables instead of hard-coding credentials in production.

---

## ▶️ Running the Application

From the project root:

```bash
mvn clean install
mvn spring-boot:run
```

By default, the backend runs at:

```text
http://localhost:8080
```

---

## 📌 Example REST Endpoints

Adjust these to match your actual controller mappings.

### Employee APIs

| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| POST   | /api/employees         | Create a new employee           |
| GET    | /api/employees         | Get all employees               |
| GET    | /api/employees/{id}    | Get employee by ID              |
| PUT    | /api/employees/{id}    | Update an existing employee     |
| DELETE | /api/employees/{id}    | Delete an employee              |

### Department APIs (if implemented)

| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| GET    | /api/departments       | Get all departments             |
| POST   | /api/departments       | Create a new department         |

---

## 🧱 Architecture Overview

- **Controller Layer** – Handles HTTP requests and returns HTTP responses.
- **DTO Layer** – Encapsulates payloads exposed by the API; protects entity models.
- **Service Layer** – Contains business logic, validation, and transaction coordination.
- **Repository Layer** – Interfaces extending Spring Data JPA to interact with PostgreSQL.
- **Entity Layer** – JPA-annotated domain models mapped to database tables.
- **Exception Layer** – Global exception handling using `@ControllerAdvice` with custom error objects.

---

## 📜 Version Control

- Clean `.gitignore` (no `target/`, no `.idea/`, no `*.iml` committed)
- Modular commits with clear messages like:
    - `Add employee entity and repository`
    - `Implement employee CRUD APIs`
    - `Add global exception handler`

---

## 📄 License

Open for learning, demos, and portfolio use.
