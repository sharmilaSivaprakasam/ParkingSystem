package com.webapp.parkingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.parkingsystem.domain.Booking;
import com.webapp.parkingsystem.service.ParkingService;

@RestController
@RequestMapping("/parking")
@PreAuthorize("hasRole('ROLE_USER')")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("/book")
    public Booking bookParkingLot(@RequestBody Booking booking) throws Exception {
        return parkingService.bookParkingLot(booking);
    }

    //    @PostMapping("/bulkBook")
    //    public ResponseEntity storeReadings(@RequestBody List<Booking> bookings) {
    //
    //    }

}
