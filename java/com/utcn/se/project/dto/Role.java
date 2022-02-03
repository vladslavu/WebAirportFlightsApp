package com.utcn.se.project.dto;

import com.utcn.se.project.exception.RoleException;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Role {
    FLIGHT_ASSISTANT("FLIGHT_ASSISTANT"),
    PILOT("PILOT"),
    COPILOT("COPILOT");

    private final String role;

    private static final Map<String, Role> fromStringMap = Stream.of(values())
            .collect(Collectors.toMap(Role::asString, Function.identity()));

    Role(String role) {
        this.role = role;
    }

    public String asString() {
        return role;
    }

    public static Role of(String Role) throws RoleException {
        return Optional.ofNullable(fromStringMap.get(Role))
                .orElseThrow(() -> new RoleException("Role not found!"));
    }
}
