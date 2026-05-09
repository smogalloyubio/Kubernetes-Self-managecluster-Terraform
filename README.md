# Library Management System

## Overview

This project is a simple Library Management System built with Spring Boot and Thymeleaf, designed to demonstrate backend development principles and CI/CD pipelines. It allows users to manage books, including adding, editing, deleting, searching, borrowing, and returning them.

## Features

*   **Book Management**: Add, edit, delete, and view book details.
*   **Search Functionality**: Search for books by title or author.
*   **Borrow/Return**: Mark books as borrowed by a user and return them.
*   **User Authentication**: Simple login functionality using Spring Security.
*   **REST APIs**: Exposes RESTful endpoints for programmatic access to book data.

## Technical Stack

### Backend

*   **Java 21**: The core programming language.
*   **Spring Boot 3.2.5**: Framework for building robust, production-ready applications.
*   **Spring Data JPA**: For data access and persistence with Hibernate.
*   **Lombok**: Reduces boilerplate code.
*   **Spring Security**: For authentication and authorization.

### Database

*   **MySQL**: Relational database for storing book information.
*   **H2 Database**: In-memory database used for testing.

### Frontend

*   **Thymeleaf**: Server-side Java template engine for web applications.
*   **Bootstrap 5**: CSS framework for responsive and modern UI design.

## DevOps Requirements

*   **Docker**: Containerization of the application and database.
*   **GitHub Actions**: Automated CI/CD pipeline.
*   **Unit Testing**: Comprehensive unit and integration tests with JUnit.
*   **Deployment-ready Configuration**: `Dockerfile` and `docker-compose.yml` for easy deployment.

## Project Structure

```
library-management-system
├── .github/workflows
│   └── ci-cd.yml
├── src
│   ├── main
│   │   ├── java/com/example/library
│   │   │   ├── config
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller
│   │   │   │   ├── BookRestController.java
│   │   │   │   └── BookWebController.java
│   │   │   ├── dto
│   │   │   ├── exception
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   └── ResourceNotFoundException.java
│   │   │   ├── model
│   │   │   │   └── Book.java
│   │   │   ├── repository
│   │   │   │   └── BookRepository.java
│   │   │   ├── service
│   │   │   │   ├── BookService.java
│   │   │   │   └── BookServiceImpl.java
│   │   │   └── LibraryManagementSystemApplication.java
│   │   └── resources
│   │       ├── static/css
│   │       ├── static/js
│   │       ├── templates
│   │       │   ├── book-add.html
│   │       │   ├── book-list.html
│   │       │   ├── book-update.html
│   │       │   └── layout.html
│   │       └── application.properties
│   └── test
│       ├── java/com/example/library
│       │   └── BookServiceTest.java
│       └── resources
│           └── application-test.properties
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 21
*   Maven 3.6+
*   Docker and Docker Compose
*   Git

### Local Setup

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/YOUR_USERNAME/library-management-system.git
    cd library-management-system
    ```

2.  **Build the application (without running tests):**
    ```bash
    mvn clean install -DskipTests
    ```

3.  **Run with Docker Compose:**
    This will start both the MySQL database and the Spring Boot application.
    ```bash
    docker-compose up --build
    ```

    The application will be accessible at `http://localhost:8080`.

### Accessing the Application

*   **Web UI**: Open your browser and navigate to `http://localhost:8080`.
*   **Login Credentials**: 
    *   Username: `admin`
    *   Password: `admin123`
*   **REST API**: Access API endpoints at `http://localhost:8080/api/books`.

## CI/CD Pipeline (GitHub Actions)

The `.github/workflows/ci-cd.yml` file defines the CI/CD pipeline:

*   **Build and Test**: On every push and pull request to `main`, the workflow will:
    *   Checkout the code.
    *   Set up JDK 21.
    *   Build the project with Maven.
    *   Run all JUnit tests.
*   **Docker Build**: On pushes to `main`, after successful build and tests, the workflow will:
    *   Build a Docker image for the application.
    *   (Placeholder for deployment steps, e.g., pushing to Docker Hub and deploying to a server).

## Clean Architecture Principles

The project follows clean architecture principles by separating concerns into distinct layers:

*   **Domain Layer (Model)**: Contains the `Book` entity, representing the core business logic.
*   **Data Layer (Repository)**: `BookRepository` handles data persistence operations, abstracting the database.
*   **Service Layer**: `BookService` and `BookServiceImpl` encapsulate business rules and orchestrate operations.
*   **Presentation Layer (Controller)**: `BookWebController` handles web requests and `BookRestController` handles API requests, both interacting with the service layer.

## Exception Handling

Global exception handling is implemented using `@ControllerAdvice` (`GlobalExceptionHandler`) to provide consistent error responses for REST APIs and user-friendly error pages for the web UI. `ResourceNotFoundException` is a custom exception for handling cases where a requested resource is not found.

## Unit Testing

Unit tests are written using JUnit 5 and Mockito to ensure the correctness of the service layer logic. `BookServiceTest` demonstrates how to test the `BookService` methods in isolation.

## Contributing

Feel free to fork the repository, open issues, and submit pull requests. Any contributions are welcome!
