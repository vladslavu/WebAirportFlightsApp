package com.utcn.se.project.service;

import com.utcn.se.project.dto.AirportEventDTO;
import com.utcn.se.project.dto.TicketDTO;
import com.utcn.se.project.exception.NotFoundException;
import com.utcn.se.project.mapper.AirportEventMapper;
import com.utcn.se.project.mapper.StaffMemberMapper;
import com.utcn.se.project.mapper.TicketMapper;
import com.utcn.se.project.model.AirportEvent;
import com.utcn.se.project.model.Ticket;
import com.utcn.se.project.repository.AirportRepository;
import com.utcn.se.project.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        TicketDTO ticketDto = TicketMapper.toDTO(ticket);
        return TicketMapper.toEntity(ticketRepository.save(ticketDto));
    }

    @Override
    public Ticket getTicketById(int id) {
        Optional<TicketDTO> ticketDTO = ticketRepository.findById(id);
        if(ticketDTO.isEmpty()) {
            throw new NotFoundException("The ticket was not found");
        }
        return TicketMapper.toEntity(ticketDTO.get());
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll().stream().map(TicketMapper::toEntity).collect(Collectors.toList());
    }
}
