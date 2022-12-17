package com.hotel.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.entity.HotelEntity;
import com.hotel.booking.model.HotelModel;
import com.hotel.booking.service.HotelService;

@RestController
@RequestMapping(value="api/rooms/")
public class HotelController {
	
	@Autowired
	private HotelService hotel;
	
	@GetMapping(value="get/hotels")
	public List<HotelEntity> gethotels(){
		List<HotelEntity> resp = hotel.getAllHotels();
		return resp;
	}
	
	
	@PostMapping(value="add/hotels")
	public String addHotels(@RequestBody HotelModel hotels) {
		boolean checkflag;
		String resp;
		checkflag = hotel.addHotelRoom(hotels);
		if(checkflag == true) {
			resp = "Room added successfully";
		}
		else {
			resp = "Error adding Room";
		}
		return resp;
	}

}
