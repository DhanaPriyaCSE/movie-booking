package com.project.movie_booking.web;


import com.project.movie_booking.model.Movie;
import com.project.movie_booking.model.Payment;
import com.project.movie_booking.service.MovieService;
import com.project.movie_booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value="payments",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> getPayments(){

        return paymentService.getAllPayments();
    }

    @RequestMapping(value="payments/{paymentId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Payment getPaymentBypaymentId(@PathVariable("paymentId") Long paymentId){
        return paymentService.getPaymentById(paymentId);
    }

    @RequestMapping(value="payments",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
        Payment createdPayment = paymentService.createPayment(payment);
        return Optional.ofNullable(createdPayment)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="payments",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> CreatePayment(@RequestBody Payment payment){
        Payment CreatedPayment=paymentService.createPayment(payment);
        return Optional.ofNullable(CreatedPayment)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="payments/{paymentId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> deletePaymentById(@PathVariable("paymentId") Long paymentId){
        paymentService.deletePaymentById(paymentId);
        return new ResponseEntity<> (HttpStatus.OK);
    }

}
