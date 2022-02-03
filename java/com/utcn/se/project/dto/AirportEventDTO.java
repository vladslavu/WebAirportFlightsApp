package com.utcn.se.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "AirplaneEvent")
@Table(name = "airplane_event")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class AirportEventDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_airplane_event")
    private int idAirplaneEvent;

    @Column(name = "id_airplane")
    private int idAirplane;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "start_location")
    private String startLocation;

    @Column(name = "end_location")
    private String endLocation;

    @Column(name = "number_of_passengers")
    private int numberOfPassengers;

    @Column(name = "luggage_weight")
    @ColumnDefault(value = "0")
    private int luggageWeight;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private EventType type;

    public AirportEventDTO() {
    }

    public AirportEventDTO(int idAirplane, LocalDateTime startDate, LocalDateTime endDate,
                           String startLocation, String endLocation, int numberOfPassengers, int luggageWeight,
                           String status, EventType type) {
        this.idAirplane = idAirplane;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.numberOfPassengers = numberOfPassengers;
        this.luggageWeight = luggageWeight;
        this.status = status;
        this.type = type;
    }

    public AirportEventDTO(int idAirplaneEvent, int idAirplane, LocalDateTime startDate,
                           LocalDateTime endDate, String startLocation, String endLocation,
                           int numberOfPassengers, int luggageWeight, String status, EventType type) {
        this.idAirplaneEvent = idAirplaneEvent;
        this.idAirplane = idAirplane;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.numberOfPassengers = numberOfPassengers;
        this.luggageWeight = luggageWeight;
        this.status = status;
        this.type = type;
    }

    public AirportEventDTO(AirportEventBuilder builder) {
        this.idAirplaneEvent = builder.idAirplaneEvent;
        this.idAirplane = builder.idAirplane;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.startLocation = builder.startLocation;
        this.endLocation = builder.endLocation;
        this.numberOfPassengers = builder.numberOfPassengers;
        this.luggageWeight = builder.luggageWeight;
        this.status = builder.status;
        this.type = builder.type;
    }

    public int getIdAirplaneEvent() {
        return idAirplaneEvent;
    }

    public void setIdAirplaneEvent(int idAirplaneEvent) {
        this.idAirplaneEvent = idAirplaneEvent;
    }

    public int getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(int idAirplane) {
        this.idAirplane = idAirplane;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(int luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirportEventDTO)) return false;
        AirportEventDTO that = (AirportEventDTO) o;
        return getIdAirplaneEvent() == that.getIdAirplaneEvent() && getIdAirplane() == that.getIdAirplane() && getNumberOfPassengers() == that.getNumberOfPassengers() && getLuggageWeight() == that.getLuggageWeight() && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate()) && Objects.equals(getStartLocation(), that.getStartLocation()) && Objects.equals(getEndLocation(), that.getEndLocation()) && Objects.equals(getStatus(), that.getStatus()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAirplaneEvent(), getIdAirplane(), getStartDate(), getEndDate(), getStartLocation(), getEndLocation(), getNumberOfPassengers(), getLuggageWeight(), getStatus(), getType());
    }

    @Override
    public String toString() {
        return "AirportEventDTO{" +
                "idAirplaneEvent=" + idAirplaneEvent +
                ", idAirplane=" + idAirplane +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", luggageWeight=" + luggageWeight +
                ", status='" + status + '\'' +
                ", type=" + type +
                '}';
    }

    public static class AirportEventBuilder {
        private int idAirplaneEvent;
        private int idAirplane;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String startLocation;
        private String endLocation;
        private int numberOfPassengers;
        private int luggageWeight;
        private String status;
        private EventType type;

        public AirportEventBuilder idAirplaneEvent(int idAirplaneEvent) {
            this.idAirplaneEvent = idAirplaneEvent;
            return this;
        }

        public AirportEventBuilder idAirplane(int idAirplane) {
            this.idAirplane = idAirplane;
            return this;
        }

        public AirportEventBuilder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public AirportEventBuilder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public AirportEventBuilder startLocation(String startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public AirportEventBuilder endLocation(String endLocation) {
            this.endLocation = endLocation;
            return this;
        }

        public AirportEventBuilder numberOfPassengers(int numberOfPassengers) {
            this.numberOfPassengers = numberOfPassengers;
            return this;
        }

        public AirportEventBuilder luggageWeight(int luggageWeight) {
            this.luggageWeight = luggageWeight;
            return this;
        }

        public AirportEventBuilder status(String status) {
            this.status = status;
            return this;
        }

        public AirportEventBuilder type(EventType type) {
            this.type = type;
            return this;
        }

        public AirportEventDTO build() {
            return new AirportEventDTO(this);
        }
    }
}
