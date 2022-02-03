package com.utcn.se.project.service;

import com.utcn.se.project.model.EventStaffAssignation;

import java.util.List;

public interface EventStaffAssignationService {

    EventStaffAssignation createEventStaffAssignation(EventStaffAssignation eventStaffAssignation);

    EventStaffAssignation getEventStaffAssignationById(int id);

    List<EventStaffAssignation> getAllEventStaffAssignation();
}
