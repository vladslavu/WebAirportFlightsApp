package com.utcn.se.project.mapper;

import com.utcn.se.project.dto.AirplaneCompanyDTO;
import com.utcn.se.project.model.AirplaneCompany;

public class AirplaneCompanyMapper {

    public static AirplaneCompany toEntity(AirplaneCompany airplaneCompanyDTO) {
        return new AirplaneCompany.AirplaneCompanyBuilder()
                .idCompany(airplaneCompanyDTO.getIdCompany())
                .name(airplaneCompanyDTO.getName())
                .capital(airplaneCompanyDTO.getCapital())
                .country(airplaneCompanyDTO.getCountry())
                .city(airplaneCompanyDTO.getCity())
                .street(airplaneCompanyDTO.getStreet())
                .streetNumber(airplaneCompanyDTO.getStreetNumber())
                .numberOfEmployees(airplaneCompanyDTO.getNumberOfEmployees())
                .build();
    }

    public static AirplaneCompanyDTO toDTO(AirplaneCompany airplaneCompany) {
        return new AirplaneCompanyDTO.AirplaneCompanyBuilder()
                .idCompany(airplaneCompany.getIdCompany())
                .name(airplaneCompany.getName())
                .capital(airplaneCompany.getCapital())
                .country(airplaneCompany.getCountry())
                .city(airplaneCompany.getCity())
                .street(airplaneCompany.getStreet())
                .streetNumber(airplaneCompany.getStreetNumber())
                .numberOfEmployees(airplaneCompany.getNumberOfEmployees())
                .build();
    }
}
