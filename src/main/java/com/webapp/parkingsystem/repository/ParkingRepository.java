package com.webapp.parkingsystem.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.webapp.parkingsystem.domain.Booking;

@Repository
public class ParkingRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Booking> findBookingByLocationNameAndDate(Booking booking) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Booking.LOCATION_NAME).is(booking.getLocationName()).and(Booking.FROM_DATE)
              .lte(booking.getToDate()).and(Booking.TO_DATE).gte(booking.getFromDate()));
        query.addCriteria(Criteria.where(Booking.FROM_TIME).lte(booking.getToTime()).and(Booking.TO_DATE)
              .gte(booking.getFromTime()));

        return mongoTemplate.find(query, Booking.class);
    }

    public Booking saveBooking(Booking booking) {
        return mongoTemplate.insert(booking);
    }
}
