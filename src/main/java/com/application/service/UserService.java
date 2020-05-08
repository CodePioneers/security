package com.application.service;

import com.application.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserService {



    @GetMapping(path="Hello/path-variable/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  String getProducts(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        user.setPassword(name);
        String message="password verified for ".concat(String.format(name).concat(" in the web service"));
                return message;


    }



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

}
