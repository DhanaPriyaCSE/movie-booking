package com.ticketbooking.api.flimhub.repository;


import com.ticketbooking.api.flimhub.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {



}
