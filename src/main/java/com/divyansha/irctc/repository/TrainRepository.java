package com.divyansha.irctc.repository;

import com.divyansha.irctc.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findByTrainNumber(String trainNumber);
}
