package com.project.movie_booking.repository;

import com.project.movie_booking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie deleteMovieBymovieId(Long movieId);
}
