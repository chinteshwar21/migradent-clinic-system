# Migradent Clinic – Architecture Document (V2)

## Overview
Migradent Clinic is a secure, production-ready full-stack web application for a dental clinic located in Nagpur, Maharashtra, India.

The system enables:
- Public users to view services and book appointments
- Registered users to manage bookings (future scope)
- Admin users to manage doctors, services, and appointments
- Secure authentication using Spring Security with JWT

---

## Technology Stack

Frontend:
- React (HTML, CSS, JavaScript)
- Axios for API communication

Backend:
- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate Validator

Database:
- MySQL

Authentication:
- JWT (Access Token based)
- BCrypt password hashing

---

## Architecture Pattern

Three-Tier Architecture (Stateless)

1. Presentation Layer – React
2. Application Layer – Spring Boot REST APIs
3. Data Layer – MySQL

Application is stateless. SessionCreationPolicy.STATELESS is enforced.

---

## Security Architecture

Authentication Flow:
1. User logs in
2. Credentials validated
3. JWT generated
4. Token sent in Authorization header
5. JWT filter validates token before controller access

Security Configuration Includes:
- Stateless session management
- JWT authentication filter before UsernamePasswordAuthenticationFilter
- BCryptPasswordEncoder bean
- Role-based access control (ADMIN, USER)
- CSRF disabled (stateless REST API)
- CORS configured for frontend domain

---

## Backend Package Structure

com.migradent
├── controller
├── service
├── repository
├── model
├── dto
├── security
├── exception
├── config
└── util

---

## Deployment Architecture

Frontend:
- Vercel / Netlify

Backend:
- AWS EC2 / Render

Database:
- MySQL Cloud

---

## Logging Strategy

- SLF4J with Logback
- No sensitive data logged
- Errors logged with correlation IDs
