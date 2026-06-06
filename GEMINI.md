# Project Instructions: Library Management System (Three-Tier Architecture)

This document provides foundational mandates, architectural patterns, and development workflows for the refactored Library Management System project.

## Architecture & Conventions

- **Frontend Tier**: Static HTML/JS served by Nginx on port 80. Uses `fetch` to communicate with the backend.
- **Backend Tier**: Spring Boot 3.2.5 REST API on port 8080.
  - **Layers**: Model, Repository, Service, REST Controller.
  - **CORS**: Enabled on controllers to allow frontend access.
- **Data Tier**: MySQL 8.0 database on port 3306.
- **Orchestration**: Docker Compose managed at the root level.

## Development Workflow

- **Build & Run**: `docker-compose up --build`
- **Backend Development**: Work inside the `/backend` directory.
- **Frontend Development**: Work inside the `/frontend` directory.
- **Testing**:
  - Backend tests: `cd backend && mvn test`.
  - Frontend: Manual verification via browser at `http://localhost`.

## Coding Standards

- **API First**: All new features must be implemented as REST endpoints in the backend first.
- **Decoupling**: Never add server-side rendering (Thymeleaf) back to the backend.
- **Lombok**: Continue using Lombok in the backend.
- **CORS**: Ensure `@CrossOrigin` is present on all new controllers.

## AI Agent Instructions (Mandates)

- **Surgical Edits**: Use `replace` for backend Java and frontend JS/HTML.
- **Validation**: After backend changes, run `mvn compile` inside `/backend`.
- **Three-Tier Integrity**: Maintain the separation between frontend and backend. Never mix them.
- **Commit Messages**: `feat(backend): ...` or `feat(frontend): ...`.

