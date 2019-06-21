package com.project.movie_booking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Theatre {

    @Id
    private Integer theatreId;
    private String theatreName;


    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="theatreId",referencedColumnName = "theatreId")
    private List<Seatmanagement> seatmanagements;

    @ManyToOne
    @JoinColumn(name = "locationId",referencedColumnName = "locationId")
    private Location location;


    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="theatreId",referencedColumnName = "theatreId")
    private List<TheatreMovieMap> theatreMovieMaps;



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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Seatmanagement> getSeatmanagements() {
        return seatmanagements;
    }

    public void setSeatmanagements(List<Seatmanagement> seatmanagements) {
        this.seatmanagements = seatmanagements;
    }

    public List<TheatreMovieMap> getTheatreMovieMaps() {
        return theatreMovieMaps;
    }

    public void setTheatreMovieMaps(List<TheatreMovieMap> theatreMovieMaps) {
        this.theatreMovieMaps = theatreMovieMaps;
    }
}
