package com.utcn.se.project.service;

import com.utcn.se.project.dto.UserDTO;
import com.utcn.se.project.mapper.UserMapper;
import com.utcn.se.project.repository.UserRepositoryAux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositoryAux userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDTO> userDTO = userRepo.getUserByUsername(username);
        if(userDTO.isEmpty())
        {
            throw new UsernameNotFoundException("User not found!");
        }
        return new CustomUserDetails(UserMapper.toEntity(userDTO.get()));
    }
}
