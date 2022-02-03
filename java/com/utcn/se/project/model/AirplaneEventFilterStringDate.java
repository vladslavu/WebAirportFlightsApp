package com.utcn.se.project.model;

import java.util.Objects;

public class AirplaneEventFilterStringDate {

    private String startLocation;
    private String endLocation;
    private String startDate;
    private String endDate;

    public AirplaneEventFilterStringDate(String startLocation, String endLocation, String startDate, String endDate) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AirplaneEventFilterStringDate(AirplaneEventFilterStringDateBuilder builder) {
        this.startLocation = builder.startLocation;
        this.endLocation = builder.endLocation;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public AirplaneEventFilterStringDate() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirplaneEventFilter)) return false;
        AirplaneEventFilter that = (AirplaneEventFilter) o;
        return Objects.equals(getStartLocation(), that.getStartLocation()) && Objects.equals(getEndLocation(), that.getEndLocation()) && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartLocation(), getEndLocation(), getStartDate(), getEndDate());
    }

    public static class AirplaneEventFilterStringDateBuilder {
        private String startLocation;
        private String endLocation;
        private String startDate;
        private String endDate;

        public AirplaneEventFilterStringDateBuilder startLocation(String startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public AirplaneEventFilterStringDateBuilder endLocation(String endLocation) {
            this.endLocation = endLocation;
            return this;
        }

        public AirplaneEventFilterStringDateBuilder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public AirplaneEventFilterStringDateBuilder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }


        public AirplaneEventFilterStringDate build() {
            return new AirplaneEventFilterStringDate(this);
        }
    }
}
