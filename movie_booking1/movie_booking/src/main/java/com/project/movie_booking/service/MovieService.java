package com.project.movie_booking.service;

import com.project.movie_booking.model.Movie;
import com.project.movie_booking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private  MovieRepository movieRepository;


    public  List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();

    }

    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).get();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovieById(Long movieId) {
         movieRepository.deleteById(movieId);
    }
}
