package com.divyansha.irctc.service;

import com.divyansha.irctc.dto.AvailabilityResponse;
import com.divyansha.irctc.entity.Seat;
import com.divyansha.irctc.entity.Train;
import com.divyansha.irctc.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final TrainService trainService;
    public SeatService(SeatRepository seatRepository, TrainService trainService) {
        this.seatRepository = seatRepository;
        this.trainService = trainService;
    }

    public List<Seat> getSeatsByTrainId(Long trainId) {
        return seatRepository.findByTrainId(trainId);
    }

    public AvailabilityResponse getAvailability(Long trainId) {
        Train train = trainService.getTrainById(trainId);
        int availableSeats = seatRepository.findByTrainIdAndStatus(trainId, "AVAILABLE").size();
        return new AvailabilityResponse(trainId, train.getTotalSeats(), availableSeats);
    }
}