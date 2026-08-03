package com.divyansha.irctc.controller;

import com.divyansha.irctc.entity.Ticket;
import com.divyansha.irctc.entity.User;
import com.divyansha.irctc.service.TicketService;
import com.divyansha.irctc.service.UserService;
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
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/{userId}/tickets")
    public List<Ticket> getUserTickets(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId);
    }
}
