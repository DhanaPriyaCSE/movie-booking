package com.project.movie_booking.repository;

import com.project.movie_booking.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment ,Long> {



}
