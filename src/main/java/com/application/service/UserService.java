package com.application.service;

import com.application.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @RequestMapping(value = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping(value = "/api/authenticateUser",
    method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> validateUser(@RequestBody User  user) {
        if(user.getName().equalsIgnoreCase("pioneers")) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/getUser",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser() {
        User user = new User();
        user.setName("pioneers");
        user.setPassword("name");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
