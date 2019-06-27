package com.project.movie_booking.service;

import com.project.movie_booking.model.Payment;
import com.project.movie_booking.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaymentService {

    @Autowired
    private  PaymentRepository paymentRepository;


    public  List<Payment> getAllPayments() {
        return (List<Payment>) paymentRepository.findAll();

    }


    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).get();
    }


    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePaymentById(Long paymentId) {
         paymentRepository.deleteById(paymentId);
    }
}
