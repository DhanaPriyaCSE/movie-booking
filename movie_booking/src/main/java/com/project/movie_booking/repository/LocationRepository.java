package com.project.movie_booking.repository;


import com.project.movie_booking.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location ,Long> {


    void deleteBylocationId(Long locationId);
}
