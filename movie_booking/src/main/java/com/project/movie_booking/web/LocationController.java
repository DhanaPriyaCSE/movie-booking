package com.project.movie_booking.web;

import com.project.movie_booking.model.Location;
import com.project.movie_booking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value="locations",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Location>getLocations(){
        return locationService.getAllLocations();
    }

    @RequestMapping(value="/locations/{locationId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Location getLocationById(@PathVariable("locationId")Long locationId){
            return locationService.getLocationById(locationId);
    }

    @RequestMapping(value="/locations",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location>CreateLocation(@RequestBody Location location){
        Location CreatedLocation=locationService.createLocation(location);
        return Optional.ofNullable(CreatedLocation)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());

    }

    @RequestMapping(value="/locations",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
        Location createdLocation=locationService.createLocation(location);
        return Optional.ofNullable(createdLocation)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/locations/{locationId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> deleteLocationbylocationId(@PathVariable("locationId") Long locationId){
        System.out.println(locationId);
        locationService.deleteLocationBylocationId(locationId);
        return new ResponseEntity<> (HttpStatus.OK);
    }



}
