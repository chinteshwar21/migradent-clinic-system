# MVP Technical Document (V2)
Migradent Clinic – Nagpur

## MVP Objective

Deliver a secure and validated web application with:
- Public appointment booking
- Admin management panel
- JWT-based authentication
- Backend validation enforcement

---

## Features

Public:
- View services
- View doctors
- Book appointment (validated)

Authentication:
- Register
- Login
- JWT token generation

Admin:
- View all appointments
- Manage services
- Delete appointments

---

## Validation Strategy

All incoming DTOs validated using:

- @NotBlank
- @Email
- @Size
- @Pattern
- @Future

Example Phone Validation:
^[6-9]\d{9}$

Appointment date must be future date.

---

## Database Schema (Core Tables)

users:
- id
- name
- email (UNIQUE, NOT NULL)
- password (hashed)
- role
- created_at
- updated_at

appointments:
- id
- user_id (FK)
- doctor_id (FK)
- appointment_date
- status
- created_at

---

## Error Handling

GlobalExceptionHandler implemented.

Standard Error Response Format:

{
  "timestamp": "",
  "status": 400,
  "error": "",
  "message": "",
  "path": ""
}

---

## Future Improvements

- Refresh Token implementation
- Redis caching
- SMS confirmation
- Docker deployment
