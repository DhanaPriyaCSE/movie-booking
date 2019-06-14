package com.ticketbooking.api.flimhub.repository;


import com.ticketbooking.api.flimhub.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {

}
