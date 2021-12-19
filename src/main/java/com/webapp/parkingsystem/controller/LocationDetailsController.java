package com.webapp.parkingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.parkingsystem.domain.Location;
import com.webapp.parkingsystem.service.LocationDetailService;

@RestController
@RequestMapping("/locations")
@PreAuthorize("hasROLE('ROLE_ADMIN')")
public class LocationDetailsController {

    @Autowired
    private LocationDetailService locationDetailService;

    @GetMapping("/view")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Location> viewLocations() {
        return locationDetailService.getAllLocations();
    }

    @PostMapping("/add")
    public Location storeLocations(@RequestBody Location location) {
        return locationDetailService.addLocation(location);
    }

    @DeleteMapping("/delete/{name}")
    public void storeLocations(@PathVariable String locationName) {
        locationDetailService.deleteLocation(locationName);
    }

    @PutMapping("/update")
    public Location updateLocation(@RequestBody Location location) {
        return locationDetailService.updateLocation(location);
    }
}
