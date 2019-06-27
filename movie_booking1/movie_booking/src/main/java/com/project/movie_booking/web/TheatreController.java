package com.project.movie_booking.web;


import com.project.movie_booking.model.Movie;
import com.project.movie_booking.model.Theatre;
import com.project.movie_booking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @CrossOrigin
    @RequestMapping(value="theatres",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Theatre> getTheatres(){
        return theatreService.getAllTheatres();
    }

    @RequestMapping(value="theatres/{theatreId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Theatre getTheatreById(@PathVariable("theatreId") Integer theatreId){
        return theatreService.getTheatreById(theatreId);
    }

    @RequestMapping(value="theatres",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre){
        Theatre createdTheatre = theatreService.createTheatre(theatre);
        return Optional.ofNullable(createdTheatre)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());


    }

    @RequestMapping(value="theatres",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Theatre> CreateTheatre(@RequestBody Theatre theatre){
        Theatre CreatedTheatre=theatreService.createTheatre(theatre);
        return Optional.ofNullable(CreatedTheatre)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="theatres/{theatreId}",method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteTheatreBytheatreId(@PathVariable("theatreId") Integer theatreId){
        theatreService.deleteById(theatreId);
        return  new ResponseEntity<> (HttpStatus.OK);
    }
}
