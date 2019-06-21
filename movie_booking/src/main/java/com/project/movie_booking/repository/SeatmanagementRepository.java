package com.project.movie_booking.repository;

import com.project.movie_booking.model.Seatmanagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatmanagementRepository extends JpaRepository<Seatmanagement,Long> {


    Seatmanagement deleteSeatmanagementByseatId(Long seatId);
}
