package com.utcn.se.project.model;

import com.utcn.se.project.dto.EventType;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Objects;

public class AirportEventStringDate {
    private int idAirplaneEvent;
    private int idAirplane;
    private String startDate;
    private String endDate;
    private String startLocation;
    private String endLocation;
    private int numberOfPassengers;
    private int luggageWeight;
    private String status;
    private EventType type;

    public AirportEventStringDate() {
    }

    public AirportEventStringDate(int idAirplane, String startDate, String endDate,
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

    public AirportEventStringDate(AirportEventStringDateBuilder builder) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
        if (!(o instanceof AirportEvent)) return false;
        AirportEvent that = (AirportEvent) o;
        return getIdAirplaneEvent() == that.getIdAirplaneEvent() && getIdAirplane() == that.getIdAirplane() && getNumberOfPassengers() == that.getNumberOfPassengers() && getLuggageWeight() == that.getLuggageWeight() && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate()) && Objects.equals(getStartLocation(), that.getStartLocation()) && Objects.equals(getEndLocation(), that.getEndLocation()) && Objects.equals(getStatus(), that.getStatus()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAirplaneEvent(), getIdAirplane(), getStartDate(), getEndDate(), getStartLocation(), getEndLocation(), getNumberOfPassengers(), getLuggageWeight(), getStatus(), getType());
    }

    @Override
    public String toString() {
        return "AirportEvent{" +
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

    public static class AirportEventStringDateBuilder {
        private int idAirplaneEvent;
        private int idAirplane;
        private String startDate;
        private String endDate;
        private String startLocation;
        private String endLocation;
        private int numberOfPassengers;
        private int luggageWeight;
        private String status;
        private EventType type;

        public AirportEventStringDateBuilder idAirplaneEvent(int idAirplaneEvent) {
            this.idAirplaneEvent = idAirplaneEvent;
            return this;
        }

        public AirportEventStringDateBuilder idAirplane(int idAirplane) {
            this.idAirplane = idAirplane;
            return this;
        }

        public AirportEventStringDateBuilder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public AirportEventStringDateBuilder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public AirportEventStringDateBuilder startLocation(String startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public AirportEventStringDateBuilder endLocation(String endLocation) {
            this.endLocation = endLocation;
            return this;
        }

        public AirportEventStringDateBuilder numberOfPassengers(int numberOfPassengers) {
            this.numberOfPassengers = numberOfPassengers;
            return this;
        }

        public AirportEventStringDateBuilder luggageWeight(int luggageWeight) {
            this.luggageWeight = luggageWeight;
            return this;
        }

        public AirportEventStringDateBuilder status(String status) {
            this.status = status;
            return this;
        }

        public AirportEventStringDateBuilder type(EventType type) {
            this.type = type;
            return this;
        }

        public AirportEventStringDate build() {
            return new AirportEventStringDate(this);
        }
    }
}
