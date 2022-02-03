package com.utcn.se.project.repository;

import com.utcn.se.project.dto.TicketDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository  extends JpaRepository<TicketDTO, Integer> {

}
