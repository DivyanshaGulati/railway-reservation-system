package com.divyansha.irctc.controller;

import com.divyansha.irctc.dto.AvailabilityResponse;
import com.divyansha.irctc.entity.Train;
import com.divyansha.irctc.service.SeatService;
import com.divyansha.irctc.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    private final TrainService trainService;
    private final SeatService seatService;
    TrainController(TrainService trainService, SeatService seatService) {
        this.trainService = trainService;
        this.seatService = seatService;
    }

    @PostMapping
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    // For Admin
    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable Long id) {
        return trainService.getTrainById(id);
    }

    // For Passengers
    @GetMapping("/number/{trainNumber}")
    public Train getTrainByTrainNumber(@PathVariable String trainNumber) {
        return trainService.getTrainByTrainNumber(trainNumber);
    }

    @GetMapping("/{trainId}/availability")
    public AvailabilityResponse getAvailability(@PathVariable Long trainId) {
        return seatService.getAvailability(trainId);

    }
}
