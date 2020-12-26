package com.rs.us.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rs.us.entity.User;
import com.rs.us.service.UserService;

import lombok.NonNull;

@RestController
public class UnlockAccountController{
	
    private UserService userService;
    public UnlockAccountController(UserService userService) {
		super();
		this.userService = userService;
	}



	//screen handling will be dealt by angular only save data and send data
    @PutMapping("api/v1/user")
    public ResponseEntity<String> resetPasswordAndUnlockAccHandler(@RequestBody @NonNull User user){
        String response = userService.resetPasswordAndUnlock(user.getEmail(),"temp",user.getPassword());
        return new ResponseEntity<>(response,HttpStatus.OK);
        
    }

}
