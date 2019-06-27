package com.project.movie_booking.repository;

import com.project.movie_booking.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface RatingRepository extends JpaRepository<Rating,Integer> {


    Rating deleteRatingById(Integer id);
}
