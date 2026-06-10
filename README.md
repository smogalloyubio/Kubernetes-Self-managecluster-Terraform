# 📚 Library Management System (Pro)

Welcome to the **Library Management System**! This is a modern, professional-grade three-tier application designed to manage a library's book collection with ease. Whether you're a seasoned developer or just starting your coding journey, this guide will help you get the system up and running in minutes.

---

## 🏗️ The "Building Blocks" (Architecture)

Think of this project like a restaurant:
1.  **The Dining Area (Frontend)**: What you see and click on. It's built with HTML, CSS, and JavaScript.
2.  **The Kitchen (Backend)**: Where all the "cooking" (logic) happens. It's built with Spring Boot (Java).
3.  **The Pantry (Database)**: Where all the ingredients (book data) are stored. We use MySQL for this.

---

## 🚀 Quick Start: How to Run This Project

Even if you've never run a program before, you can follow these "magic formulas" (commands) to see the library in action!

### 1. Prerequisites (The Tools You Need)
Before we start, make sure you have these installed on your computer:
*   [Docker Desktop](https://www.docker.com/products/docker-desktop/) (This is like a container that holds all our building blocks).

### 2. The "Magic Formula" (Running the App)
1.  Open your **Terminal** (or Command Prompt).
2.  Go to the folder where you saved this project.
3.  Type this command and press **Enter**:
    ```bash
    docker-compose up --build
    ```
4.  Wait for the text to stop moving. Once it's ready, open your web browser and go to:
    👉 **http://localhost**

---

## 🛠️ Technical Details for Developers

### Tech Stack
| Tier | Technology | Purpose |
| :--- | :--- | :--- |
| **Frontend** | Nginx, HTML5, CSS3, JavaScript (ES6+) | User Interface & API Interaction |
| **Backend** | Java 21, Spring Boot 3.2.5, Spring Security | RESTful API & Business Logic |
| **Database** | MySQL 8.0 | Persistent Data Storage |
| **Infra** | Terraform, Kubernetes, Docker | Deployment & Orchestration |

### Project Structure
```text
.
├── backend/            # The Java "Kitchen" (API)
├── frontend/           # The Web "Dining Area" (UI)
├── kubernetes/         # Instructions for cloud deployment
├── terraform/          # Instructions for building cloud servers
└── docker-compose.yml  # The "Master Plan" to run everything locally
```

---

## 🧪 How to Test

### Backend Tests
To make sure the "Kitchen" is working correctly:
```bash
cd backend
mvn test
```

### API Access
You can talk directly to the backend at:
`http://localhost:8080/api/books`

---

## 🔐 Security & Access
*   **Default Username**: `admin`
*   **Default Password**: `admin123`

---

## 🤝 Contributing
Found a bug or want to add a cool feature?
1. Fork the project.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

---
*Developed with ❤️ for the Developer Community.*
