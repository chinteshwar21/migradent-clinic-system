# System Design Document (V2)
Migradent Clinic – Nagpur

---

## System Overview

Frontend → React  
Backend → Spring Boot + Spring Security  
Database → MySQL  

Stateless REST architecture with JWT authentication.

---

## Entity Relationships

User (1) → (Many) Appointments  
Doctor (1) → (Many) Appointments  

Foreign key constraints enforced.

---

## Authentication Flow

1. Login request
2. Credential validation
3. JWT generated
4. Token attached in Authorization header
5. JWT filter validates token
6. Role-based authorization applied

---

## Request Lifecycle

Client Request
→ Security Filter
→ Controller
→ DTO Validation
→ Service Layer (@Transactional)
→ Repository
→ Database
→ Response

---

## Scalability Strategy

- Horizontal scaling via load balancer
- Redis caching (future)
- Docker containerization
- CI/CD pipeline
- AWS deployment

---

## Security Enhancements

- Access token expiration (15 mins)
- Refresh token (future)
- Input sanitization
- Rate limiting (future)
- Audit fields in tables

---

## Monitoring

- Application logs
- Error monitoring
- Performance tracking
