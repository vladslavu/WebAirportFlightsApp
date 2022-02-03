package com.utcn.se.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;


@Entity(name = "EventStaffAssignation")
@Table(name = "event_staff_assignation")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class EventStaffAssignationDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_event_staff_assignation")
    private int idEventStaffAssignation;

    @Column(name = "id_airplane_event")
    private int idAirplaneEvent;

    @Column(name = "id_staff_member")
    private int idStaffMember;

    @Column(name = "role")
    private Role role;

    public EventStaffAssignationDTO() {
    }

    public EventStaffAssignationDTO(int idEventStaffAssignation, int idAirplaneEvent, int idStaffMember, Role role) {
        this.idEventStaffAssignation = idEventStaffAssignation;
        this.idAirplaneEvent = idAirplaneEvent;
        this.idStaffMember = idStaffMember;
        this.role = role;
    }

    public EventStaffAssignationDTO( int idAirplaneEvent, int idStaffMember, Role role) {
        this.idAirplaneEvent = idAirplaneEvent;
        this.idStaffMember = idStaffMember;
        this.role = role;
    }

    public EventStaffAssignationDTO(EventStaffAssignationBuilder builder) {
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

        public EventStaffAssignationDTO build() {
            return new EventStaffAssignationDTO(this);
        }
    }
}
