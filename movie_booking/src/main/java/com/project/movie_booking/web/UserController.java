package com.project.movie_booking.web;

import com.project.movie_booking.model.Location;
import com.project.movie_booking.model.User;
import com.project.movie_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="users",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value="/users/{userid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable ("userid") Long userid){ return userService.getUserById(userid);}

    @CrossOrigin
    @RequestMapping(value="/users/login",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public Boolean checkUser(@RequestBody User user){
        return userService.authUser(user.getMailid(),user.getPswd());
    }


    @CrossOrigin
    @RequestMapping(value="/users",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return Optional.ofNullable(createdUser)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/users",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        User CreatedUser = userService.createUser(user);
        return Optional.ofNullable(CreatedUser)
                .map(u->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/users/{id}",method=RequestMethod.DELETE,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> deleteUserById(@PathVariable ("id")Long id){
        System.out.println(id);
        userService.deleteUserById(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }




}
