package com.utcn.se.project.model;

import com.utcn.se.project.dto.UserRole;

import java.time.LocalDateTime;
import java.util.Objects;

public class AirplaneEventFilter {

    private String startLocation;
    private String endLocation;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public AirplaneEventFilter(String startLocation, String endLocation, LocalDateTime startDate, LocalDateTime endDate) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AirplaneEventFilter(AirplaneEventFilterBuilder builder) {
        this.startLocation = builder.startLocation;
        this.endLocation = builder.endLocation;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public AirplaneEventFilter() {

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

    public static class AirplaneEventFilterBuilder {
        private String startLocation;
        private String endLocation;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public AirplaneEventFilterBuilder startLocation(String startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public AirplaneEventFilterBuilder endLocation(String endLocation) {
            this.endLocation = endLocation;
            return this;
        }

        public AirplaneEventFilterBuilder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public AirplaneEventFilterBuilder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }


        public AirplaneEventFilter build() {
            return new AirplaneEventFilter(this);
        }
    }
}
