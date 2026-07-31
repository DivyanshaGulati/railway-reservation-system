# IRCTC Railway Reservation System

## 1. Problem Statement

The Railway Reservation System is a backend application that allows users to search trains, book tickets, view bookings, and cancel tickets. The system manages users, trains, seats, and bookings while ensuring that a seat cannot be booked by more than one user.

## 2. Functional Requirements

### User
- Register
- Login
- View Profile

### Train
- Search trains
- View train details

### Seat
- View seat availability

### Ticket
- Book ticket
- View booked tickets
- Cancel ticket

### Admin
- Add train
- Update train details
- Delete train

## 3. Non-Functional Requirements

- The system should support multiple users at the same time.
- A seat cannot be booked by more than one user.
- User passwords should be stored securely.
- APIs should respond quickly.
- The booking process should be consistent. Either the ticket is booked successfully along with payment, or no booking should occur.
- The system should be easy to maintain and extend.

## 4. Entities

### User
Represents a passenger or administrator using the system.

### Train
Represents a train available for booking.

### Seat
Represents an individual seat in a train.

### Ticket
Represents a successful booking made by a user.

### Station
Represents a railway station used as source or destination.

## 5. Entity Relationships

- One User can book many Tickets.
- One Train has many Seats.
- One Train can have many Tickets.
- One Ticket belongs to one User.
- One Ticket belongs to one Train.
- One Ticket is booked for one Seat.
- One Train has one Source Station.
- One Train has one Destination Station.

## 6. Booking Flow

User
→ Login
→ Search Train
→ View Train Details
→ View Seat Availability
→ Select Seat
→ Book Ticket
→ Ticket Generated
→ View Ticket
→ Cancel Ticket (Optional)

## 7. API Design

### User APIs
- POST /api/users/register
- POST /api/users/login
- GET /api/users/profile

### Train APIs
- GET /api/trains
- GET /api/trains/{id}

### Seat APIs
- GET /api/trains/{trainId}/seats

### Ticket APIs
- POST /api/tickets/book
- GET /api/tickets
- DELETE /api/tickets/{ticketId}

### Admin APIs
- POST /api/admin/trains
- PUT /api/admin/trains/{id}
- DELETE /api/admin/trains/{id}

## 8. Database Design

Tables

- users
- trains
- seats
- tickets
- stations

## 9. Tech Stack

### Backend
- Java 21
- Spring Boot 3.x

### Database
- PostgreSQL

### ORM
- Spring Data JPA (Hibernate)

### Build Tool
- Gradle

### Security
- Spring Security
- JWT Authentication

### Testing
- JUnit 5
- Mockito

### API Documentation
- Swagger (OpenAPI)

### API Testing
- Postman

### Version Control
- Git
- GitHub

### Development Tools
- IntelliJ IDEA

## 10. Future Improvements

- Payment Integration
- Waitlist
- RAC
- Email Notifications
- SMS Notifications
- Live Train Status
- Admin Dashboard
