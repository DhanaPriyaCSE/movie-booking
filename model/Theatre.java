package com.project.movie_booking.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Theatre {

    @Id
    private Integer theatreId;
    private String theatreName;

    @OneToMany
    @JoinColumn(name="theatreId")
    private Seatmanagement seatmanagement;

    @ManyToOne
    @JoinColumn(name="locationId")
    private Location location;

    @OneToMany
    @JoinColumn(name="theatreId")
    private TheatreMoviemap theatreMoviemap;



    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }


}
