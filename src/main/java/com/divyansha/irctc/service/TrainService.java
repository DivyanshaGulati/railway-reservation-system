package com.divyansha.irctc.service;

import com.divyansha.irctc.entity.Seat;
import com.divyansha.irctc.entity.Train;
import com.divyansha.irctc.repository.SeatRepository;
import com.divyansha.irctc.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    private TrainRepository trainRepository;
    private SeatRepository seatRepository;
    public TrainService(TrainRepository trainRepository, SeatRepository seatRepository) {
        this.trainRepository = trainRepository;
        this.seatRepository = seatRepository;
    }
    public Train addTrain(Train train) {
        Train savedTrain = trainRepository.save(train);
        for(int i=1; i<=savedTrain.getTotalSeats(); i++) {
            Seat seat = new Seat();
            seat.setSeatNumber("S" + i);
            seat.setSeatType("GENERAL");
            seat.setStatus("AVAILABLE");
            // Connect Seat to Train
            seat.setTrain(savedTrain);
            // Save Seat
            seatRepository.save(seat);
        }
        return savedTrain;
    }
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }
    public Train getTrainById(Long id) {
        return trainRepository.findById(id).orElse(null);
    }
    public Train getTrainByTrainNumber(String trainNumber) {
        return trainRepository.findByTrainNumber(trainNumber);
    }
}
