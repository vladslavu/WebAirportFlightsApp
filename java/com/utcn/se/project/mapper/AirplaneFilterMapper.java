package com.utcn.se.project.mapper;


import com.utcn.se.project.model.AirplaneEventFilter;
import com.utcn.se.project.model.AirplaneEventFilterStringDate;

import java.time.LocalDateTime;

public class AirplaneFilterMapper {

    public static AirplaneEventFilter toEntity(AirplaneEventFilterStringDate eventFilter) {
        return new AirplaneEventFilter.AirplaneEventFilterBuilder()
                .startDate(LocalDateTime.parse(eventFilter.getStartDate()))
                .endDate(LocalDateTime.parse(eventFilter.getEndDate()))
                .startLocation(eventFilter.getStartLocation())
                .endLocation(eventFilter.getEndLocation())
                .build();
    }

    public static AirplaneEventFilterStringDate toStringDate(AirplaneEventFilter eventFilter) {
        return new AirplaneEventFilterStringDate.AirplaneEventFilterStringDateBuilder()
                .startDate(String.valueOf(eventFilter.getStartDate()))
                .endDate(String.valueOf(eventFilter.getEndDate()))
                .startLocation(eventFilter.getStartLocation())
                .endLocation(eventFilter.getEndLocation())
                .build();
    }
}
