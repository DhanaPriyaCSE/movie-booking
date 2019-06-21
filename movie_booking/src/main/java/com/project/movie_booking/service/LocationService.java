package com.project.movie_booking.service;

import com.project.movie_booking.model.Location;
import com.project.movie_booking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {

    @Autowired
    private  LocationRepository locationRepository;


    public  List<Location> getAllLocations() {
        return (List<Location>) locationRepository.findAll();

    }

    public  Location getLocationById(Long locationId) {
        return locationRepository.findById(locationId).get();
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }


    public void  deleteLocationBylocationId(Long locationId)
    {
         locationRepository.deleteById(locationId);
    }
}
