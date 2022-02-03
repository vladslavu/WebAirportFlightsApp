package com.utcn.se.project.mapper;

import com.utcn.se.project.dto.AirplaneDTO;
import com.utcn.se.project.model.Airplane;

public class AirplaneMapper {

    public static Airplane toEntity(AirplaneDTO airplaneDTO) {
        return new Airplane.AirplaneBuilder()
                .idAirplane(airplaneDTO.getIdAirplane())
                .name(airplaneDTO.getName())
                .idCompany(airplaneDTO.getIdCompany())
                .passengerCapacity(airplaneDTO.getPassengerCapacity())
                .luggageCapacity(airplaneDTO.getLuggageCapacity())
                .build();
    }

    public static AirplaneDTO toDTO(Airplane airplane) {
        return new AirplaneDTO.AirplaneBuilder()
                .idAirplane(airplane.getIdAirplane())
                .name(airplane.getName())
                .idCompany(airplane.getIdCompany())
                .passengerCapacity(airplane.getPassengerCapacity())
                .luggageCapacity(airplane.getLuggageCapacity())
                .build();
    }
}
