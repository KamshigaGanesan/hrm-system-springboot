# Human Resource Management System (HRM)

## Overview

The Human Resource Management System (HRM) is a backend application developed using Java Spring Boot and PostgreSQL. This project provides RESTful APIs for managing employee-related information and HR operations. The system demonstrates backend development concepts such as CRUD operations, database integration, and API testing.

## Technologies Used

* Java
* Spring Boot
* PostgreSQL
* Gradle
* Spring Data JPA
* REST APIs
* Postman
* Git & GitHub

## Features

* Employee Management
* Create Employee Records
* Retrieve Employee Details
* Update Employee Information
* Delete Employee Records
* RESTful API Development
* Database Integration with PostgreSQL
* API Testing using Postman
* Spring Data JPA Integration

## Project Structure

```text
src/main/java       - Java source code
src/main/resources  - Application configuration files
build.gradle        - Gradle dependencies and build configuration
```

## Installation

### Clone the Repository

```bash
git clone https://github.com/KamshigaGanesan/hrm-system-springboot.git
```

### Configure Database

1. Create a PostgreSQL database.
2. Update the database configuration in `application.properties`.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hrm_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run the Application

For Windows:

```bash
gradlew.bat bootRun
```

For Linux/Mac:

```bash
./gradlew bootRun
```

## API Testing

All REST APIs were tested successfully using Postman.

## Learning Outcomes

This project helped in gaining practical experience with:

* Spring Boot Development
* RESTful API Design
* PostgreSQL Database Integration
* Spring Data JPA
* CRUD Operations
* Backend Application Development
* Git and GitHub Version Control

## Future Enhancements

* JWT Authentication
* Role-Based Access Control
* Attendance Management
* Leave Management
* Payroll Management
* Frontend Integration
* Docker Deployment
* Cloud Deployment

## Project Status

✅ Backend Development Completed

✅ PostgreSQL Database Integration Completed

✅ REST APIs Tested Using Postman

🚀 Ready for Future Enhancements

## Author
**Kamshiga Ganesan**

