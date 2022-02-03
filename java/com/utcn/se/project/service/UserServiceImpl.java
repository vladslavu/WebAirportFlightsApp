package com.utcn.se.project.service;

import com.utcn.se.project.dto.UserDTO;
import com.utcn.se.project.dto.UserRole;
import com.utcn.se.project.encoder.PasswordEncoder;
import com.utcn.se.project.exception.AuthenticationException;
import com.utcn.se.project.exception.CreateException;
import com.utcn.se.project.exception.NotFoundException;
import com.utcn.se.project.factory.UserJWTGenerator;
import com.utcn.se.project.mapper.UserMapper;
import com.utcn.se.project.model.AuthenticatedUser;
import com.utcn.se.project.model.AuthenticationRequest;
import com.utcn.se.project.model.AuthenticationResponse;
import com.utcn.se.project.model.User;
import com.utcn.se.project.repository.UserRepository;
import com.utcn.se.project.repository.UserRepositoryAux;
import com.utcn.se.project.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String AUTHENTICATION_ERROR_MESSAGE = "The email or password is invalid!";
    private static final String CREATE_ERROR_MESSAGE = "The account could not be created! The email already exists or bad email/username";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryAux userRepositoryAux;

    @Autowired
    private UserJWTGenerator userJWTGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(int id) {
        Optional<UserDTO> userDTO = userRepository.findById(id);
        if (userDTO.isEmpty()) {
            throw new NotFoundException("The user was not found");
        }
        return UserMapper.toEntity(userDTO.get());
    }

    @Override
    public User createUser(User user) {
        if (!UserValidator.isValidEmail(user.getEmail()) || !UserValidator.isValidPassword(user.getPassword())) {
            throw new AuthenticationException(CREATE_ERROR_MESSAGE);
        }

        UserDTO userDTO = UserMapper.toDTO(user);
        Optional<UserDTO> optionalUser = userRepositoryAux.getUserByEmail(user.getEmail());
        if (optionalUser.isEmpty()) {
            return UserMapper.toEntity(userRepository.save(userDTO));
        }
        throw new CreateException(CREATE_ERROR_MESSAGE);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<UserDTO> userDTO = userRepositoryAux.getUserByUsername(username);
        if (userDTO.isEmpty()) {
            throw new NotFoundException("The user was not found");
        }
        return UserMapper.toEntity(userDTO.get());
    }

    @Override
    public AuthenticationResponse createUserAuthenticationToken(AuthenticationRequest request) {
        if (!UserValidator.isValidEmail(request.getEmail()) || !UserValidator.isValidPassword(request.getPassword())) {
            throw new AuthenticationException(AUTHENTICATION_ERROR_MESSAGE);
        }
        Optional<UserDTO> optionalUser = userRepositoryAux.getUserByEmail(request.getEmail());
        if (optionalUser.isEmpty()) {
            throw new AuthenticationException(AUTHENTICATION_ERROR_MESSAGE);
        }
        UserDTO user = optionalUser.get();
        if (!passwordEncoder.getEncoder().matches(request.getPassword(), user.getPassword())) {
            throw new AuthenticationException(AUTHENTICATION_ERROR_MESSAGE);
        }
        AuthenticatedUser authenticatedUser = new AuthenticatedUser.AuthenticatedUserDTOBuilder()
                .userId(user.getIdUser())
                .email(user.getEmail())
                .role(user.getRole())
                .build();

        String jwt = userJWTGenerator.generate(authenticatedUser);
        return new AuthenticationResponse(jwt);
    }
}
