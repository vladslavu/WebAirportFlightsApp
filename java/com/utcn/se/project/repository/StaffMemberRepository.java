package com.utcn.se.project.repository;

import com.utcn.se.project.dto.StaffMemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffMemberRepository extends JpaRepository<StaffMemberDTO, Integer> {
}
