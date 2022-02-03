package com.utcn.se.project.mapper;

import com.utcn.se.project.dto.UserDTO;
import com.utcn.se.project.dto.UserRole;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet resultSet, int i) throws SQLException {

        return new UserDTO.UserBuilder()
                .idUser(resultSet.getInt("id_user"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .email(resultSet.getString("email"))
                .role(UserRole.valueOf(getRole(resultSet.getInt("role"))))
                .build();
    }

    private String getRole(int role)
    {
        switch(role)
        {
            case 0:
                return "ADMIN";
            case 1:
                return "CUSTOMER";
            case 2:
                return "STAFF_MANAGER";
            case 3:
                return "EVENT_MANAGER";
            default: return "GUEST";
        }
    }
}