package com.project.movie_booking.repository;

import com.project.movie_booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


Optional<User> findByMailidAndPswd(String mailid,String pswd);
}
