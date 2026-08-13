package com.divyansha.irctc.service;

import com.divyansha.irctc.dto.BookingRequest;
import com.divyansha.irctc.entity.Seat;
import com.divyansha.irctc.entity.Ticket;
import com.divyansha.irctc.entity.Train;
import com.divyansha.irctc.entity.User;
import com.divyansha.irctc.exception.*;
import com.divyansha.irctc.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Ticket bookTicket(BookingRequest bookingRequest) {

        User user = userRepository.findById(bookingRequest.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found"));

        Train train = trainRepository.findById(bookingRequest.getTrainId()).orElseThrow(()-> new TrainNotFoundException("Train not found"));

        Seat seat = seatRepository.findById(bookingRequest.getSeatId()).orElseThrow(()-> new SeatNotFoundException("Seat not found"));

        if (!seat.getTrain().getId().equals(train.getId())) {
            throw new SeatTrainMismatchException("Seat does not belong to the selected train");
        }

        if (!seat.getStatus().equals("AVAILABLE")) {
            throw new SeatAlreadyBookedException("Seat is already booked");
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