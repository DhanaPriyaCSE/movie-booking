package com.project.movie_booking.model;


import javax.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long bookingId;

    @OneToOne
    @JoinColumn(name="userid")
    private User user;

    @OneToOne
    @JoinColumn(name="theatreId")
    private Theatre theatre;

    @OneToOne
    @JoinColumn(name="seatId")
    private Seatmanagement seatmanagement;

    @OneToOne
    @JoinColumn(name="movieId")
    private  Movie movie;

    @OneToOne
    @JoinColumn(name="paymentId")
    private Payment payment;


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
}
