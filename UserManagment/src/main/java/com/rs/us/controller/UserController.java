package com.rs.us.controller;

import com.rs.us.entity.User;
import com.rs.us.service.UserService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
	
	
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/v1/countries")
    public ResponseEntity<Map<Integer,String>> loadCountries(){
        return new ResponseEntity<Map<Integer, String>>(userService.getCountries(),HttpStatus.OK);
    }


    @GetMapping("/api/v1/states/{id}")
    public ResponseEntity<Map<Integer,String>> loadStates(@PathVariable("id") Integer id){
        return new ResponseEntity<Map<Integer, String>>(userService.getStates(id),HttpStatus.OK);
    }

    @GetMapping("/api/v1/cities/{id}")
    public ResponseEntity<Map<Integer,String>> loadCities(@PathVariable("id") Integer id){
        return new ResponseEntity<Map<Integer, String>>(userService.getCities(id),HttpStatus.OK);
    }

    @PostMapping("/api/v1/user")
    public ResponseEntity<User> registerUser(@RequestBody @NonNull  User user){
        try {

            return new ResponseEntity(userService.saveUser(user), HttpStatus.CREATED);

        }catch(Exception e){ return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); }
    }



    @PostMapping("/api/v1/login")
    public ResponseEntity<String> validUser(@RequestBody @NonNull User user){
        return new ResponseEntity<>(userService.loginCheck(user.getEmail(),user.getPassword()),HttpStatus.OK);
    }


  

    //forgot screen end point



}
