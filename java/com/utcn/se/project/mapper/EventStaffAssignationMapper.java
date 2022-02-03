package com.utcn.se.project.mapper;

import com.utcn.se.project.dto.EventStaffAssignationDTO;
import com.utcn.se.project.model.EventStaffAssignation;

public class EventStaffAssignationMapper {

    public static EventStaffAssignation toEntity(EventStaffAssignationDTO eventStaffAssignationDTO) {
        return new EventStaffAssignation.EventStaffAssignationBuilder()
                .idAirplaneEvent(eventStaffAssignationDTO.getIdAirplaneEvent())
                .idEventStaffAssignation(eventStaffAssignationDTO.getIdEventStaffAssignation())
                .idStaffMember(eventStaffAssignationDTO.getIdStaffMember())
                .role(eventStaffAssignationDTO.getRole())
                .build();
    }

    public static EventStaffAssignationDTO toDTO(EventStaffAssignation eventStaffAssignation) {
        return new EventStaffAssignationDTO.EventStaffAssignationBuilder()
                .idEventStaffAssignation(eventStaffAssignation.getIdEventStaffAssignation())
                .idAirplaneEvent(eventStaffAssignation.getIdAirplaneEvent())
                .idStaffMember(eventStaffAssignation.getIdStaffMember())
                .role(eventStaffAssignation.getRole())
                .build();
    }
}
