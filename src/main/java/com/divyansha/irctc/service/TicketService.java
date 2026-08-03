package com.divyansha.irctc.service;

import com.divyansha.irctc.entity.Seat;
import com.divyansha.irctc.entity.Ticket;
import com.divyansha.irctc.exception.TicketNotFoundException;
import com.divyansha.irctc.repository.SeatRepository;
import com.divyansha.irctc.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;

    public TicketService(TicketRepository ticketRepository, SeatRepository seatRepository) {
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
    }
    public Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException("Ticket Not Found."));
    }

    public String cancelTicket(Long ticketId) {
        Ticket ticket = getTicket(ticketId);
        Seat seat = ticket.getSeat();
        seat.setStatus("AVAILABLE");
        seatRepository.save(seat);
        ticketRepository.delete(ticket);
        return "Ticket cancelled successfully.";
    }

    public List<Ticket> getTicketsByUser(Long userId){
        return ticketRepository.findByUserId(userId);
    }
}
