package com.utcn.se.project.service;

import com.utcn.se.project.model.AuthenticationRequest;
import com.utcn.se.project.model.AuthenticationResponse;
import com.utcn.se.project.model.User;

public interface UserService {

    User createUser(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    AuthenticationResponse createUserAuthenticationToken(AuthenticationRequest request);
}
