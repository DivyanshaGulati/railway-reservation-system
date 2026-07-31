package com.divyansha.irctc.repository;

import com.divyansha.irctc.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByTrainId(Long trainId);
    List<Seat> findByTrainTrainNumber(String trainNumber);
}