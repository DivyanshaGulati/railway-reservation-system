package com.divyansha.irctc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {

    private Long userId;

    private Long trainId;

    private Long seatId;

}