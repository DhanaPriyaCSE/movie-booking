package com.project.movie_booking.web;


import com.project.movie_booking.model.Movie;
import com.project.movie_booking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value="Movie",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovies(){

        return movieService.getAllMovies();
    }

    @RequestMapping(value="Movie/{movieId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieById(@PathVariable("movieId") Long movieId){
        return movieService.getMovieById(movieId);
    }

    @RequestMapping(value="Movie",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie createdMovie = movieService.createMovie(movie);
        return Optional.ofNullable(createdMovie)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());


    }

    @RequestMapping(value="Movie",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> CreateMovie(@RequestBody Movie movie){
        Movie CreatedMovie=movieService.createMovie(movie);
        return Optional.ofNullable(CreatedMovie)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="Movie/{movieId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> deleteMovieBymovieId(@PathVariable("movieId") Long movieId){
        movieService.deleteMovieById(movieId);
        return  new ResponseEntity<> (HttpStatus.OK);
    }
}
