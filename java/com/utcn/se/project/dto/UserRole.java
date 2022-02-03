package com.utcn.se.project.dto;

import com.utcn.se.project.exception.UserRoleException;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UserRole {
    ADMIN ("ADMIN"),
    CUSTOMER ("CUSTOMER"),
    STAFF_MANAGER("STAFF_MANAGER"),
    EVENT_MANAGER("EVENT_MANAGER"),
    GUEST("GUEST");

    private final String userRole;

    private static final Map<String, UserRole> fromStringMap = Stream.of(values())
            .collect(Collectors.toMap(UserRole::asString, Function.identity()));

    UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String asString() {
        return userRole;
    }

    public static UserRole of(String userRole) throws UserRoleException {
        return Optional.ofNullable(fromStringMap.get(userRole))
                .orElseThrow(() -> new UserRoleException("userRole not found!"));
    }
}
