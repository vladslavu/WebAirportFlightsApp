package com.utcn.se.project.service;

import com.utcn.se.project.dto.AirportEventDTO;
import com.utcn.se.project.exception.NotFoundException;
import com.utcn.se.project.mapper.AirportEventMapper;
import com.utcn.se.project.model.AirportEvent;
import com.utcn.se.project.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    private static AirportServiceImpl singleInstanceAirportServiceImpl = null;

    private AirportServiceImpl(){}

    public static AirportServiceImpl getInstance() {
        if(singleInstanceAirportServiceImpl == null)
            singleInstanceAirportServiceImpl = new AirportServiceImpl();

        return singleInstanceAirportServiceImpl;
    }

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public AirportEvent createAirportEvent(AirportEvent airportEvent) {
        AirportEventDTO airportEventDTO = AirportEventMapper.toDTO(airportEvent);
        return AirportEventMapper.toEntity(airportRepository.save(airportEventDTO));
    }

    @Override
    public AirportEvent getAirportEventById(int id) {
        Optional<AirportEventDTO> airportEventDTO = airportRepository.findById(id);
        if(airportEventDTO.isEmpty()) {
            throw new NotFoundException("The airport event was not found");
        }
        return AirportEventMapper.toEntity(airportEventDTO.get());
    }

    @Override
    public void deleteAirportEventById(int id) {
        airportRepository.deleteById(id);
    }

    @Override
    public List<AirportEvent> getAllAirportEvents() {
        return airportRepository.findAll().stream().map(AirportEventMapper::toEntity).collect(Collectors.toList());
    }
}
