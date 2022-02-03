package com.utcn.se.project.service;

import com.utcn.se.project.model.AirportEvent;

import java.util.List;

public interface AirportService {

    AirportEvent createAirportEvent(AirportEvent airportEvent);

    AirportEvent getAirportEventById(int id);

    void deleteAirportEventById(int id);

    List<AirportEvent> getAllAirportEvents();
}
