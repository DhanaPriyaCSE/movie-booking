package com.project.movie_booking.web;

import com.project.movie_booking.model.Movie;
import com.project.movie_booking.model.Rating;
import com.project.movie_booking.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value="ratings",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Rating> getRatings(){
        return ratingService.getAllRatings();
    }

    @RequestMapping(value="/ratings/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Rating getRatingById(@PathVariable("id") Integer id){
        return ratingService.getRatingById(id);
    }

    @RequestMapping(value="ratings",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating createdRating = ratingService.createRating(rating);
        return Optional.ofNullable(createdRating)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());


    }

    @RequestMapping(value="ratings",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> CreateRating(@RequestBody Rating rating){
        Rating CreatedRating=ratingService.createRating(rating);
        return Optional.ofNullable(CreatedRating)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="ratings/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteRatingById(@PathVariable("id") Integer id){
        ratingService.deleteRatingByid(id);
        return new  ResponseEntity<> (HttpStatus.OK);
    }
}
