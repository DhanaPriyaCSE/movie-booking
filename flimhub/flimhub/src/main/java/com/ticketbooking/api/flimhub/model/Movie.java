package com.ticketbooking.api.flimhub.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private String  movieId;
    private String movieName;
    private String Synopsis;
    private String directer;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }

    public String getDirecter() {
        return directer;
    }

    public void setDirecter(String directer) {
        this.directer = directer;
    }
}
