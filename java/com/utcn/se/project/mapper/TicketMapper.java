package com.utcn.se.project.mapper;

import com.utcn.se.project.dto.TicketDTO;
import com.utcn.se.project.model.Ticket;

public class TicketMapper {

    public static Ticket toEntity(TicketDTO ticketDTO) {
        return new Ticket.TicketBuilder()
                .idTicket(ticketDTO.getIdTicket())
                .idUser(ticketDTO.getIdUser())
                .idEvent(ticketDTO.getIdEvent())
                .price(ticketDTO.getPrice())
                .build();
    }

    public static TicketDTO toDTO(Ticket ticket) {
        return new TicketDTO.TicketBuilder()
                .idTicket(ticket.getIdTicket())
                .idUser(ticket.getIdUser())
                .idEvent(ticket.getIdEvent())
                .price(ticket.getPrice())
                .build();
    }
}
