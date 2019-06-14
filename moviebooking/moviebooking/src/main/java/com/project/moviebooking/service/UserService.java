package com.project.moviebooking.service;

import com.project.moviebooking.model.User;
import com.project.moviebooking.repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private userRepository userRepository;

    public List<com.project.moviebooking.model.User> getAllUsers() {
        return (List<User>) userRepository.findAll();

    }

     public User getUserById(Long id){
        return userRepository.findById(id).get();
     }


    public User createUser(User user) {
        return  userRepository.save(user);
    }
}
