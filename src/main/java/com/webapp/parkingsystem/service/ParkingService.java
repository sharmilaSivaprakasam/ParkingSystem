package com.webapp.parkingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.webapp.parkingsystem.domain.Booking;
import com.webapp.parkingsystem.repository.ParkingRepository;

@Service
public class ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    public Booking bookParkingLot(Booking booking) throws Exception {
        List<Booking> existingBooking = parkingRepository.findBookingByLocationNameAndDate(booking);
        if (!CollectionUtils.isEmpty(existingBooking)) {
            throw new Exception("Parking slot is not available");
        }
        return parkingRepository.saveBooking(booking);
    }
}
