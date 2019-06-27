package com.project.movie_booking.service;

import com.project.movie_booking.model.Theatre;
import com.project.movie_booking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private  TheatreRepository theatreRepository;


    public  List<Theatre> getAllTheatres() {
        return (List<Theatre>) theatreRepository.findAll();
    }

    public Theatre getTheatreById(Integer theatreId) {
        return theatreRepository.findById(theatreId).get();
    }

    public Theatre createTheatre(Theatre theatre) {

        return theatreRepository.save(theatre);
    }

    public void deleteById(Integer theatreId) {
         theatreRepository.deleteById(theatreId);
    }
}
