package com.project.movie_booking.web;


import com.project.movie_booking.model.Movie;
import com.project.movie_booking.model.Seatmanagement;
import com.project.movie_booking.service.MovieService;
import com.project.movie_booking.service.SeatmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SeatmanagementController {

    @Autowired
    SeatmanagementService seatmanagementService;

    @RequestMapping(value = "Seatmanagement",method = RequestMethod.GET,produces =MediaType. APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Seatmanagement>> getSeatmanagements()
    {
        return new ResponseEntity<>(seatmanagementService.getAllSeatmanagements(), HttpStatus.OK);
    }

    @RequestMapping(value="/Seatmanagement/{seatId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Seatmanagement getSeatmanagementByseatId(@PathVariable("seatId") Long seatId){
        return seatmanagementService.getSeatmanagementByseatId(seatId);
    }

    @RequestMapping(value="Seatmanagement",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Seatmanagement> createSeatmanagement(@RequestBody Seatmanagement seatmanagement){
        System.out.println(seatmanagement);
        Seatmanagement createdSeatmanagement = seatmanagementService.createSeatmanagement(seatmanagement);
        return Optional.ofNullable(createdSeatmanagement)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
//        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value="Seatmanagement",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Seatmanagement> CreateSeatmanagement(@RequestBody Seatmanagement seatmanagement){
        Seatmanagement CreatedSeatmanagement=seatmanagementService.createSeatmanagement(seatmanagement);
        return Optional.ofNullable(CreatedSeatmanagement)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="Seatmanagement/{seatId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSeatmanagementByseatId(@PathVariable("seatId") Long seatId){
        System.out.println("DELETE METHOD");
        seatmanagementService.deleteSeatmanagementByseatId(seatId);
        return new ResponseEntity (HttpStatus.OK);
    }


}
