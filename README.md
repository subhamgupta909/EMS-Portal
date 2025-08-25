Employee Management System is a full-stack web application built with Spring MVC, Hibernate, and Spring Security.
It helps organisations manage employees, projects, and clients with role-based access control and real-time notifications using Apache Kafka.

Features

🔑 Role-Based Authentication (Spring Security)
Admin, Employee, and Client roles

Secure login & authorisation

👨‍💼 Employee Management
Add, update, and delete employees
Dynamic search (by ID, name, email, department, date range)

🏢 Client & Project Management

Manage clients and assign employees to projects,
Track project assignments

📡 Apache Kafka Integration

Publish events when employees/projects are created or updated
Consumers handle notifications asynchronously

📧 Email Notification System

Sends real-time emails when:
A new employee is added
A project is assigned to an employee

📊 Admin Dashboard

View and manage all employees, clients, and projects from one place

Tech Stack
Backend: Spring MVC, Hibernate, Spring Security, Apache Kafka
Frontend: JSP, HTML, CSS, Bootstrap
Database: MySQL
Messaging: Apache Kafka
Email Service: JavaMail (SMTP with TLS/SSL)
Server: Apache Tomcat

Setup Instructions
Prerequisites
JDK 11+
Maven 3.x
Apache Tomcat 9+
MySQL 8+
Apache Kafka 3.x
