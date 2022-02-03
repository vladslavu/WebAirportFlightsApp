package com.utcn.se.project.repository;

import com.utcn.se.project.dto.UserDTO;
import com.utcn.se.project.mapper.UserRowMapper;
import com.utcn.se.project.repository.factory.KeyHolderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAux {
    private static final String GET_USER_BY_EMAIL_QUERY = "SELECT * FROM USER WHERE email = ?";
    private static final String GET_USER_BY_USERNAME_QUERY = "SELECT * FROM USER WHERE username = ?";

    private final JdbcTemplate jdbcTemplate;
    private final KeyHolderFactory keyHolderFactory;
    private final UserRowMapper rowMapper;

    @Autowired
    public UserRepositoryAux(JdbcTemplate jdbcTemplate, KeyHolderFactory keyHolderFactory, UserRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.keyHolderFactory = keyHolderFactory;
        this.rowMapper = rowMapper;
    }

    public Optional<UserDTO> getUserByEmail(String email) {
        try {
            UserDTO user = jdbcTemplate.queryForObject(GET_USER_BY_EMAIL_QUERY, rowMapper, email);

            assert user != null;
            return Optional.of(user);
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        } catch (DataAccessException dataAccessException) {
            throw dataAccessException;
        }
    }

    public Optional<UserDTO> getUserByUsername(String username) {
        try {
            UserDTO user = jdbcTemplate.queryForObject(GET_USER_BY_USERNAME_QUERY, rowMapper, username);

            assert user != null;
            return Optional.of(user);
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        } catch (DataAccessException dataAccessException) {
            throw dataAccessException;
        }
    }
}
