package com.project.movie_booking.model;


import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Seatmanagement {

    @Id
    @Column(name = "SEAT_ID")
    private Long seatId;

    @Column(name = "TIMING")
    private LocalTime timing;

    @ManyToOne
    @JoinColumn(name="theatreId",referencedColumnName = "theatreId")
    private Theatre theatre;

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public LocalTime getTiming() {
        return timing;
    }

    public void setTiming(LocalTime timing) {
        this.timing = timing;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    //    @Override
//    public String toString() {
//        return "Seatmanagement{" +
//                "seatId=" + seatId +
//                ", timing=" + timing +
//                '}';
//    }
}
