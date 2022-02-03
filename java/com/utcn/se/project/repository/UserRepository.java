package com.utcn.se.project.repository;

import com.utcn.se.project.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDTO, Integer> {
}
