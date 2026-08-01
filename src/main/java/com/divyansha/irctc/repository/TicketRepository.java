package com.divyansha.irctc.repository;

import com.divyansha.irctc.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
