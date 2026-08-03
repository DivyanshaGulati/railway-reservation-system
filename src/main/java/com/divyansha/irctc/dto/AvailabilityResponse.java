package com.divyansha.irctc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityResponse {
    private Long trainId;
    private Integer totalSeats;
    private Integer availableSeats;
}
