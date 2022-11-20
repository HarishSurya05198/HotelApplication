package com.hotel.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.entity.HotelEntity;
import com.hotel.booking.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotel;
	
	public Boolean addHotelRoom(HotelEntity e) {
		try {
			hotel.save(e);
			return true;
		}
		catch (Exception exp) {
			return false;
		}
	}
	
	public List<HotelEntity> getAllHotels(){
		try {
			List<HotelEntity> list = hotel.findAll();
			return list;
		}
		catch(Exception e) {
			return null;
		}
	}
}
