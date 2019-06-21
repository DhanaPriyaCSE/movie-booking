package com.project.movie_booking.service;

import com.project.movie_booking.model.Seatmanagement;
import com.project.movie_booking.repository.SeatmanagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SeatmanagementService {

    @Autowired
    private SeatmanagementRepository seatmanagementRepository;

    public List<Seatmanagement> getAllSeatmanagements() {
        return seatmanagementRepository.findAll();
    }

    public Seatmanagement getSeatmanagementByseatId(Long seatId) {
        return seatmanagementRepository.findById(seatId).get();
    }

    public Seatmanagement createSeatmanagement(Seatmanagement seatmanagement) {
        return seatmanagementRepository.save(seatmanagement);
    }

    public  void deleteSeatmanagementByseatId(Long seatId) {
          seatmanagementRepository.deleteById(seatId);
    }
}
