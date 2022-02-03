package com.utcn.se.project.model;

import com.utcn.se.project.dto.EventStaffAssignationDTO;
import com.utcn.se.project.dto.Role;

import java.util.Objects;

public class EventStaffAssignation {
    private int idEventStaffAssignation;
    private int idAirplaneEvent;
    private int idStaffMember;
    private Role role;

    public EventStaffAssignation() {
    }

    public EventStaffAssignation(int idEventStaffAssignation, int idAirplaneEvent, int idStaffMember, Role role) {
        this.idEventStaffAssignation = idEventStaffAssignation;
        this.idAirplaneEvent = idAirplaneEvent;
        this.idStaffMember = idStaffMember;
        this.role = role;
    }

    public EventStaffAssignation( int idAirplaneEvent, int idStaffMember, Role role) {
        this.idAirplaneEvent = idAirplaneEvent;
        this.idStaffMember = idStaffMember;
        this.role = role;
    }

    public EventStaffAssignation(EventStaffAssignationBuilder builder) {
        this.idEventStaffAssignation = builder.idEventStaffAssignation;
        this.idAirplaneEvent = builder.idAirplaneEvent;
        this.idStaffMember = builder.idStaffMember;
        this.role = builder.role;
    }

    public int getIdAirplaneEvent() {
        return idAirplaneEvent;
    }

    public void setIdAirplaneEvent(int idAirplaneEvent) {
        this.idAirplaneEvent = idAirplaneEvent;
    }

    public int getIdStaffMember() {
        return idStaffMember;
    }

    public void setIdStaffMember(int idStaffMember) {
        this.idStaffMember = idStaffMember;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getIdEventStaffAssignation() {
        return idEventStaffAssignation;
    }

    public void setIdEventStaffAssignation(int idEventStaffAssignation) {
        this.idEventStaffAssignation = idEventStaffAssignation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventStaffAssignationDTO)) return false;
        EventStaffAssignationDTO that = (EventStaffAssignationDTO) o;
        return getIdEventStaffAssignation() == that.getIdEventStaffAssignation() && getIdAirplaneEvent() == that.getIdAirplaneEvent() && getIdStaffMember() == that.getIdStaffMember() && getRole() == that.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEventStaffAssignation(), getIdAirplaneEvent(), getIdStaffMember(), getRole());
    }

    @Override
    public String toString() {
        return "EventStaffAssignationDTO{" +
                "idEventStaffAssignation=" + idEventStaffAssignation +
                ", idAirplaneEvent=" + idAirplaneEvent +
                ", idStaffMember=" + idStaffMember +
                ", role=" + role +
                '}';
    }

    public static class EventStaffAssignationBuilder {
        private int idEventStaffAssignation;
        private int idAirplaneEvent;
        private int idStaffMember;
        private Role role;

        public EventStaffAssignationBuilder idEventStaffAssignation(int idEventStaffAssignation) {
            this.idEventStaffAssignation = idEventStaffAssignation;
            return this;
        }

        public EventStaffAssignationBuilder idAirplaneEvent(int idAirplaneEvent) {
            this.idAirplaneEvent = idAirplaneEvent;
            return this;
        }

        public EventStaffAssignationBuilder idStaffMember(int idStaffMember) {
            this.idStaffMember = idStaffMember;
            return this;
        }

        public EventStaffAssignationBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public EventStaffAssignation build() {
            return new EventStaffAssignation(this);
        }
    }
}
