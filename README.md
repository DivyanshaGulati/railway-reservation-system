# 🚆 IRCTC Railway Reservation System

A backend application built using Spring Boot that simulates the core functionality of the IRCTC Railway Reservation System. The application provides REST APIs for user registration, train management, seat generation, ticket booking, ticket cancellation, booking history, and train availability.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Lombok

---

## ✨ Features

### User
- Register User

### Train
- Add Train
- Get Train by ID
- Get Train by Train Number
- Get All Trains
- Check Train Availability

### Seat
- Automatic Seat Generation

### Booking
- Book Ticket
- Prevent booking of already booked seats
- Validate seat belongs to selected train

### Ticket
- View Ticket
- Cancel Ticket
- View User Booking History

### Error Handling
- Global Exception Handler
- Custom Exceptions
- Consistent Error Responses

---

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
└── exception
```

---

## 📡 REST APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/users/register` | Register User |
| POST | `/api/trains` | Add Train |
| GET | `/api/trains` | Get All Trains |
| GET | `/api/trains/{id}` | Get Train by ID |
| GET | `/api/trains/number/{trainNumber}` | Get Train by Train Number |
| GET | `/api/trains/{id}/availability` | Check Train Availability |
| POST | `/api/bookings` | Book Ticket |
| GET | `/api/tickets/{id}` | View Ticket |
| DELETE | `/api/tickets/{id}` | Cancel Ticket |
| GET | `/api/users/{id}/tickets` | Get User Booking History |

---

## 🗄 Database Entities

- User
- Train
- Seat
- Ticket

---

## 🔜 Planned Enhancements

- Request Validation
- Spring Security + JWT Authentication
- Password Encryption (BCrypt)
- Transaction Management
- Concurrency Handling
- Swagger / OpenAPI
- Docker
- CI/CD
- AWS Deployment

This project is actively being enhanced with validation, transaction management, concurrency control, authentication, testing, containerization, and cloud deployment.