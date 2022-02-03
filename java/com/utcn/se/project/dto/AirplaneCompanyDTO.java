package com.utcn.se.project.dto;

import java.util.Objects;

public class AirplaneCompanyDTO {
    private int idCompany;
    private String name;
    private int capital;
    private String country;
    private String city;
    private String street;
    private int streetNumber;
    private int numberOfEmployees;

    public AirplaneCompanyDTO() {
    }

    public AirplaneCompanyDTO(int idCompany, String name, int capital, String country, String city, String street, int streetNumber, int numberOfEmployees) {
        this.idCompany = idCompany;
        this.name = name;
        this.capital = capital;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.numberOfEmployees = numberOfEmployees;
    }

    public AirplaneCompanyDTO(String name, int capital, String country, String city, String street, int streetNumber, int numberOfEmployees) {
        this.name = name;
        this.capital = capital;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.numberOfEmployees = numberOfEmployees;
    }

    public AirplaneCompanyDTO(AirplaneCompanyBuilder builder) {
        this.name = builder.name;
        this.capital = builder.capital;
        this.country = builder.country;
        this.city = builder.city;
        this.street = builder.street;
        this.streetNumber = builder.streetNumber;
        this.numberOfEmployees = builder.numberOfEmployees;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirplaneCompanyDTO)) return false;
        AirplaneCompanyDTO that = (AirplaneCompanyDTO) o;
        return getIdCompany() == that.getIdCompany() && getCapital() == that.getCapital() && getStreetNumber() == that.getStreetNumber() && getNumberOfEmployees() == that.getNumberOfEmployees() && Objects.equals(getName(), that.getName()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreet(), that.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCompany(), getName(), getCapital(), getCountry(), getCity(), getStreet(), getStreetNumber(), getNumberOfEmployees());
    }

    @Override
    public String toString() {
        return "AirplaneCompany{" +
                "idCompany=" + idCompany +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }

    public static class AirplaneCompanyBuilder {
        private int idCompany;
        private String name;
        private int capital;
        private String country;
        private String city;
        private String street;
        private int streetNumber;
        private int numberOfEmployees;

        public AirplaneCompanyBuilder idCompany(int idCompany) {
            this.idCompany = idCompany;
            return this;
        }

        public AirplaneCompanyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AirplaneCompanyBuilder capital(int capital) {
            this.capital = capital;
            return this;
        }

        public AirplaneCompanyBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AirplaneCompanyBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AirplaneCompanyBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AirplaneCompanyBuilder streetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AirplaneCompanyBuilder numberOfEmployees(int numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
            return this;
        }

        public AirplaneCompanyDTO build() {
            return new AirplaneCompanyDTO(this);
        }
    }
}
