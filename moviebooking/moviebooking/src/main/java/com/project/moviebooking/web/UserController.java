package com.project.moviebooking.web;

import com.project.moviebooking.model.User;
import com.project.moviebooking.service.UserService;
import org.apache.tomcat.util.http.parser.MediaTypeCache;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController

{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsers(){
        return userService.getAllUsers();

    }

    @RequestMapping(value="/users/(id)",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUserById(@PathVariable Long id) {return userService.getUserById(id);
    }


    @RequestMapping(value = "/users", method= RequestMethod.POST,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return Optional.ofNullable(createdUser)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }
    @RequestMapping(value = "/users", method= RequestMethod.PUT,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return Optional.ofNullable(createdUser)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }
  /*  @RequestMapping(value = "/users/{id}", method= RequestMethod.DELETE,produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@PathVariable Long id){
        userService.deleteUserById
    }*/

}
