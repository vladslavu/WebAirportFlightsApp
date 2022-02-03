package com.utcn.se.project.dto;

import java.util.Objects;

public class AirplaneDTO {
    private int idAirplane;
    private String name;
    private int idCompany;
    private int passengerCapacity;
    private int luggageCapacity;

    public AirplaneDTO() {

    }

    public AirplaneDTO(String name, int idCompany, int passengerCapacity, int luggageCapacity) {
        this.name = name;
        this.idCompany = idCompany;
        this.passengerCapacity = passengerCapacity;
        this.luggageCapacity = luggageCapacity;
    }

    public AirplaneDTO(int idAirplane, String name, int idCompany, int passengerCapacity, int luggageCapacity) {
        this.idAirplane = idAirplane;
        this.name = name;
        this.idCompany = idCompany;
        this.passengerCapacity = passengerCapacity;
        this.luggageCapacity = luggageCapacity;
    }

    public AirplaneDTO(AirplaneBuilder airplaneBuilder) {
        this.idAirplane = airplaneBuilder.idAirplane;
        this.name = airplaneBuilder.name;
        this.idCompany = airplaneBuilder.idCompany;
        this.passengerCapacity = airplaneBuilder.passengerCapacity;
        this.luggageCapacity = airplaneBuilder.luggageCapacity;
    }

    public int getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(int idAirplane) {
        this.idAirplane = idAirplane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirplaneDTO)) return false;
        AirplaneDTO airplane = (AirplaneDTO) o;
        return getIdAirplane() == airplane.getIdAirplane() && getIdCompany() == airplane.getIdCompany() && getPassengerCapacity() == airplane.getPassengerCapacity() && getLuggageCapacity() == airplane.getLuggageCapacity() && Objects.equals(getName(), airplane.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAirplane(), getName(), getIdCompany(), getPassengerCapacity(), getLuggageCapacity());
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "idAirplane=" + idAirplane +
                ", name='" + name + '\'' +
                ", idCompany=" + idCompany +
                ", passengerCapacity=" + passengerCapacity +
                ", luggageCapacity=" + luggageCapacity +
                '}';
    }

    public static class AirplaneBuilder {
        private int idAirplane;
        private String name;
        private int idCompany;
        private int passengerCapacity;
        private int luggageCapacity;

        public AirplaneBuilder idAirplane(int idAirplane) {
            this.idAirplane = idAirplane;
            return this;
        }

        public AirplaneBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AirplaneBuilder idCompany(int idCompany) {
            this.idCompany = idCompany;
            return this;
        }

        public AirplaneBuilder passengerCapacity(int passengerCapacity) {
            this.passengerCapacity = passengerCapacity;
            return this;
        }

        public AirplaneBuilder luggageCapacity(int luggageCapacity) {
            this.luggageCapacity = luggageCapacity;
            return this;
        }

        public AirplaneDTO build() {
            return new AirplaneDTO(this);
        }
    }
}
