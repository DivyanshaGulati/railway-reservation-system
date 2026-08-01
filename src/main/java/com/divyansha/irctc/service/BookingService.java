package com.divyansha.irctc.service;

import com.divyansha.irctc.dto.BookingRequest;
import com.divyansha.irctc.entity.Seat;
import com.divyansha.irctc.entity.Ticket;
import com.divyansha.irctc.entity.Train;
import com.divyansha.irctc.entity.User;
import com.divyansha.irctc.repository.*;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final UserRepository userRepository;
    private final TrainRepository trainRepository;
    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;

    public BookingService(UserRepository userRepository,
                          TrainRepository trainRepository,
                          SeatRepository seatRepository,
                          TicketRepository ticketRepository) {

        this.userRepository = userRepository;
        this.trainRepository = trainRepository;
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket bookTicket(BookingRequest bookingRequest) {

        User user = userRepository.findById(bookingRequest.getUserId()).orElse(null);

        Train train = trainRepository.findById(bookingRequest.getTrainId()).orElse(null);

        Seat seat = seatRepository.findById(bookingRequest.getSeatId()).orElse(null);

        if (!seat.getStatus().equals("AVAILABLE")) {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setUser(user);
        ticket.setTrain(train);
        ticket.setSeat(seat);

        seat.setStatus("BOOKED");
        seatRepository.save(seat);

        return ticketRepository.save(ticket);
    }
}