package com.utcn.se.project.repository;

import com.utcn.se.project.dto.EventStaffAssignationDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventStaffAssignationRepository extends JpaRepository<EventStaffAssignationDTO, Integer> {
}
