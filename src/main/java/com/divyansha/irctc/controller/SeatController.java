package com.divyansha.irctc.controller;

import com.divyansha.irctc.entity.Seat;
import com.divyansha.irctc.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    // Admin
    @GetMapping("/train/{trainId}")
    public List<Seat> getSeatsByTrainId(@PathVariable Long trainId) {
        return seatService.getSeatsByTrainId(trainId);
    }

    // Passengers
    @GetMapping("/trainNumber/{trainNumber}")
    public List<Seat> getSeatsByTrainNumber(@PathVariable String trainNumber) {
        return seatService.getSeatsByTrainNumber(trainNumber);
    }
}