package com.utcn.se.project.repository;

import com.utcn.se.project.dto.AirportEventDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportEventDTO, Integer> {
}
