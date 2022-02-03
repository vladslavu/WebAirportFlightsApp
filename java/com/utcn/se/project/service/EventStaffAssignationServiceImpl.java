package com.utcn.se.project.service;

import com.utcn.se.project.dto.EventStaffAssignationDTO;
import com.utcn.se.project.exception.NotFoundException;
import com.utcn.se.project.mapper.AirportEventMapper;
import com.utcn.se.project.mapper.EventStaffAssignationMapper;
import com.utcn.se.project.model.AirportEvent;
import com.utcn.se.project.model.EventStaffAssignation;
import com.utcn.se.project.repository.EventStaffAssignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventStaffAssignationServiceImpl implements EventStaffAssignationService {

    @Autowired
    private EventStaffAssignationRepository eventStaffAssignationRepository;

    @Override
    public EventStaffAssignation createEventStaffAssignation(EventStaffAssignation eventStaffAssignation) {
        EventStaffAssignationDTO eventStaffAssignationDto = EventStaffAssignationMapper.toDTO(eventStaffAssignation);
        return EventStaffAssignationMapper.toEntity(eventStaffAssignationRepository.save(eventStaffAssignationDto));
    }

    @Override
    public EventStaffAssignation getEventStaffAssignationById(int id) {
        Optional<EventStaffAssignationDTO> eventStaffAssignationDto = eventStaffAssignationRepository.findById(id);
        if(eventStaffAssignationDto.isEmpty()) {
            throw new NotFoundException("The event staff assignation was not found");
        }
        return EventStaffAssignationMapper.toEntity(eventStaffAssignationDto.get());
    }

    @Override
    public List<EventStaffAssignation> getAllEventStaffAssignation() {
        return eventStaffAssignationRepository.findAll().stream().map(EventStaffAssignationMapper::toEntity).collect(Collectors.toList());
    }
}
