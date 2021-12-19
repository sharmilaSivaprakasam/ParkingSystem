package com.webapp.parkingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.parkingsystem.domain.Location;
import com.webapp.parkingsystem.repository.LocationDetailsRepository;

@Service
public class LocationDetailService {
    @Autowired
    private LocationDetailsRepository locationDetailsRepository;

    public List<Location> getAllLocations() {
        return locationDetailsRepository.findAll();
    }

    public Location addLocation(Location location) {
        return locationDetailsRepository.insert(location);
    }

    public void deleteLocation(String locationName) {
        locationDetailsRepository.deleteById(locationName);
    }

    public Location updateLocation(Location location) {
        return locationDetailsRepository.save(location);
    }
}
