package com.divyansha.irctc.controller;

import com.divyansha.irctc.entity.Train;
import com.divyansha.irctc.repository.TrainRepository;
import com.divyansha.irctc.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    private TrainService trainService;
    TrainController(TrainService trainService) {
        this.trainService = trainService;
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
}
