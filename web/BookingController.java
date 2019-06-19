package com.project.movie_booking.web;


import com.project.movie_booking.model.Booking;
import com.project.movie_booking.model.Location;
import com.project.movie_booking.repository.BookingRepository;
import com.project.movie_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value="Booking",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Booking> getBookings(){
        return bookingService.getAllBookings();
    }

    @RequestMapping(value="Booking/{bookingId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Booking getBookingById(@PathVariable("bookingId")Long bookingId){
        return bookingService.getBookingById(bookingId);
    }

    @RequestMapping(value="Booking",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> CreateBooking(@RequestBody Booking booking){
        Booking CreatedBooking=bookingService.createBooking(booking);
        return Optional.ofNullable(CreatedBooking)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());

    }

    @RequestMapping(value="Booking",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        Booking createdBooking=bookingService.createBooking(booking);
        return Optional.ofNullable(createdBooking)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="Booking/{bookingId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> deleteBookingbybookingId(@PathVariable("bookingId") Long bookingId){
        System.out.println(bookingId);
        bookingService.deleteBookingBybookingId(bookingId);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}
