package com.project.movie_booking.service;

import com.project.movie_booking.model.Rating;
import com.project.movie_booking.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private  RatingRepository ratingRepository;


    public List<Rating> getAllRatings() {
        return (List<Rating>) ratingRepository.findAll();
    }

    public Rating getRatingById(Integer id) {
        return ratingRepository.findById(id).get();
    }


    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }


    public void deleteRatingByid(Integer id) {
         ratingRepository.deleteById(id);
    }
}
