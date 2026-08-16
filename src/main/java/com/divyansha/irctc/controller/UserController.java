package com.divyansha.irctc.controller;

import com.divyansha.irctc.dto.RegisterUserRequest;
import com.divyansha.irctc.dto.UserResponse;
import com.divyansha.irctc.entity.Ticket;
import com.divyansha.irctc.entity.User;
import com.divyansha.irctc.service.TicketService;
import com.divyansha.irctc.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final TicketService ticketService;
    public UserController(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @PostMapping("/register")
    public UserResponse registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
        return userService.registerUser(registerUserRequest);
    }

    @GetMapping("/{userId}/tickets")
    public List<Ticket> getUserTickets(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId);
    }
}
