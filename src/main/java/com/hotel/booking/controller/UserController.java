package com.hotel.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.entity.UserEntity;
import com.hotel.booking.model.UserModel;
import com.hotel.booking.service.UserService;

@RestController
@RequestMapping(value="app/user/")
public class UserController {
	
	@Autowired
	private UserService users;

	@PostMapping(value="register")
	public String addUser(@RequestBody UserModel u) {

		boolean resp;
		resp = users.addUser(u);
		if(resp == true) {
			return "user added successfully!";
		}
		else {
			return "registration failed";
		}
	}
	
	@PutMapping(value="login")
	public ResponseEntity<?> loginUser(@RequestBody UserModel u){
		UserEntity userResp = users.loginUser(u);
		if(userResp != null) {
			ResponseEntity<?> resp = new ResponseEntity<>(userResp, HttpStatus.OK);
			return resp;
		}
		else {
			ResponseEntity<?> resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resp;
		}
	}
}
