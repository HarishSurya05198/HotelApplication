package com.hotel.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.hotel.booking.model.BookingModel;
import com.hotel.booking.service.BookingService;

@RestController
@RequestMapping(value = "api/v1/")
public class BookingController {
	
	@Autowired
	private BookingService book;
	
	@PostMapping(value = "add/booking")
	public ResponseEntity<?> bookRoom(@RequestBody BookingModel b){
		boolean resp = book.addbooking(b);
		if(resp == true) {
			ResponseEntity<?> response = new ResponseEntity<>("Booking added successfully", HttpStatus.OK);
			return response;
		}
		else {
			ResponseEntity<?> response = new ResponseEntity<>("Booking failed", HttpStatus.BAD_REQUEST);
			return response;
		}
	}

}
