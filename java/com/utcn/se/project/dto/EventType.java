package com.utcn.se.project.dto;

import com.utcn.se.project.exception.EventTypeException;
import com.utcn.se.project.exception.RoleException;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EventType {
    FLIGHT("FLIGHT"),
    GARAGE_TRIP("GARAGE_TRIP"),
    AIRPORT_TRIP("AIRPORT_TRIP");

    private final String eventType;

    private static final Map<String, EventType> fromStringMap = Stream.of(values())
            .collect(Collectors.toMap(EventType::asString, Function.identity()));

    EventType(String eventType) {
        this.eventType = eventType;
    }

    public String asString() {
        return eventType;
    }

    public static EventType of(String EventType) throws EventTypeException {
        return Optional.ofNullable(fromStringMap.get(EventType))
                .orElseThrow(() -> new RoleException("Role not found!"));
    }
}
