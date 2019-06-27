package com.project.movie_booking.repository;

import com.project.movie_booking.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre,Integer> {


    Theatre deleteTheatreBytheatreId(Integer theatreId);
}
