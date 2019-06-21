package com.project.movie_booking.service;

import com.project.movie_booking.model.Booking;
import com.project.movie_booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }


    public Booking getBookingById(Long bookingId)
    {
        return bookingRepository.findById(bookingId).get();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }


    public void deleteBookingBybookingId(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
