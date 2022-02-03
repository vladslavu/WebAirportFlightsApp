package com.utcn.se.project.mapper;

import com.utcn.se.project.dto.AirportEventDTO;
import com.utcn.se.project.model.AirportEvent;
import com.utcn.se.project.model.AirportEventStringDate;

import java.time.LocalDateTime;

public class AirportEventMapper {

    public static AirportEvent toEntity(AirportEventDTO airportEventDTO) {
        return new AirportEvent.AirportEventBuilder()
                .idAirplaneEvent(airportEventDTO.getIdAirplaneEvent())
                .idAirplane(airportEventDTO.getIdAirplane())
                .startDate(airportEventDTO.getStartDate())
                .endDate(airportEventDTO.getEndDate())
                .startLocation(airportEventDTO.getStartLocation())
                .endLocation(airportEventDTO.getEndLocation())
                .numberOfPassengers(airportEventDTO.getNumberOfPassengers())
                .luggageWeight(airportEventDTO.getLuggageWeight())
                .status(airportEventDTO.getStatus())
                .type(airportEventDTO.getType())
                .build();
    }

    public static AirportEventDTO toDTO(AirportEvent airportEvent) {
        return new AirportEventDTO.AirportEventBuilder()
                .idAirplaneEvent(airportEvent.getIdAirplaneEvent())
                .idAirplane(airportEvent.getIdAirplane())
                .startDate(airportEvent.getStartDate())
                .endDate(airportEvent.getEndDate())
                .startLocation(airportEvent.getStartLocation())
                .endLocation(airportEvent.getEndLocation())
                .numberOfPassengers(airportEvent.getNumberOfPassengers())
                .luggageWeight(airportEvent.getLuggageWeight())
                .status(airportEvent.getStatus())
                .type(airportEvent.getType())
                .build();
    }

    public static AirportEvent toEntityFromStringDate(AirportEventStringDate airportEvent) {
        return new AirportEvent.AirportEventBuilder()
                .idAirplaneEvent(airportEvent.getIdAirplaneEvent())
                .idAirplane(airportEvent.getIdAirplane())
                .startDate(LocalDateTime.parse(airportEvent.getStartDate()))
                .endDate(LocalDateTime.parse(airportEvent.getEndDate()))
                .startLocation(airportEvent.getStartLocation())
                .endLocation(airportEvent.getEndLocation())
                .numberOfPassengers(airportEvent.getNumberOfPassengers())
                .luggageWeight(airportEvent.getLuggageWeight())
                .status(airportEvent.getStatus())
                .type(airportEvent.getType())
                .build();
    }

    public static AirportEventStringDate toStringDateFromEntity(AirportEvent airportEvent) {
        return new AirportEventStringDate.AirportEventStringDateBuilder()
                .idAirplaneEvent(airportEvent.getIdAirplaneEvent())
                .idAirplane(airportEvent.getIdAirplane())
                .startDate(String.valueOf(airportEvent.getStartDate()))
                .endDate(String.valueOf(airportEvent.getEndDate()))
                .startLocation(airportEvent.getStartLocation())
                .endLocation(airportEvent.getEndLocation())
                .numberOfPassengers(airportEvent.getNumberOfPassengers())
                .luggageWeight(airportEvent.getLuggageWeight())
                .status(airportEvent.getStatus())
                .type(airportEvent.getType())
                .build();
    }
}
