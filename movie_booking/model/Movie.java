package com.project.movie_booking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    private  Long movieId;
    private String movieName;
    private String Synopsis;
    private  String director;


    @JsonIgnore
    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name="movieId",referencedColumnName = "movieId")
    private List<TheatreMovieMap> theatreMovieMaps;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="movieId",referencedColumnName = "movieId")
    private List<Rating> ratings;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<TheatreMovieMap> getTheatreMovieMaps() {
        return theatreMovieMaps;
    }

    public void setTheatreMovieMaps(List<TheatreMovieMap> theatreMovieMaps) {
        this.theatreMovieMaps = theatreMovieMaps;
    }
}
