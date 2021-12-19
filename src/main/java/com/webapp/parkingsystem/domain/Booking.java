package com.webapp.parkingsystem.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
    private LocalDate fromDate;
    public static final String FROM_DATE = "fromDate";

    private LocalDate toDate;
    public static final String TO_DATE = "toDate";

    private LocalTime fromTime;
    public static final String FROM_TIME = "fromTime";

    private LocalTime toTime;
    public static final String TO_TIME = "toTime";

    private String locationName;
    public static final String LOCATION_NAME = "locationName";

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
