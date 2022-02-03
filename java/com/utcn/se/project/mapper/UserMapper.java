package com.utcn.se.project.mapper;

import com.utcn.se.project.dto.UserDTO;
import com.utcn.se.project.model.User;

public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        return new User.UserBuilder()
                .idUser(userDTO.getIdUser())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .role(userDTO.getRole())
                .build();
    }

    public static UserDTO toDTO(User user) {
        return new UserDTO.UserBuilder()
                .idUser(user.getIdUser())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
