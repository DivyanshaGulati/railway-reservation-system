package com.divyansha.irctc.service;

import com.divyansha.irctc.entity.Seat;
import com.divyansha.irctc.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeatsByTrainId(Long trainId) {
        return seatRepository.findByTrainId(trainId);
    }

    public List<Seat> getSeatsByTrainNumber(String trainNumber) {
        return seatRepository.findByTrainTrainNumber(trainNumber);
    }
}