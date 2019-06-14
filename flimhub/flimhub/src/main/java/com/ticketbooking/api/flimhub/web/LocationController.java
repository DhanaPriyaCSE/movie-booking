package com.ticketbooking.api.flimhub.web;


import com.ticketbooking.api.flimhub.model.Location;
import com.ticketbooking.api.flimhub.repository.LocationRepository;
import com.ticketbooking.api.flimhub.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping(value="/locations ", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Location> getAllLocation(){
        return (List<Location>) locationRepository.findAll();
    }

    @RequestMapping(value="/locations ", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
           Location createdLocation = locationRepository.save(location);
           return Optional.ofNullable(createdLocation)
                    .map(u -> ResponseEntity.ok().body(u))
                    .orElse (ResponseEntity.notFound().build());
        }

    @RequestMapping(value="/locations ", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Location> CreateLocation(@RequestBody Location location){
        Location createdLocation = locationRepository.save(location);
        return Optional.ofNullable(createdLocation)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse (ResponseEntity.notFound().build());
    }



}
