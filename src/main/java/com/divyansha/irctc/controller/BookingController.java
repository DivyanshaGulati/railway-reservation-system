package com.divyansha.irctc.controller;

import com.divyansha.irctc.dto.BookingRequest;
import com.divyansha.irctc.entity.Ticket;
import com.divyansha.irctc.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Ticket bookTicket(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicket(bookingRequest);
    }
}