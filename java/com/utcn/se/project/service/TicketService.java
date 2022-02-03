package com.utcn.se.project.service;

import com.utcn.se.project.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    Ticket getTicketById(int id);

    List<Ticket> getAllTickets();
}
