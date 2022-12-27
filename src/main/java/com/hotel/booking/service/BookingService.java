package com.hotel.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.entity.BookingEntity;
import com.hotel.booking.entity.HotelEntity;
import com.hotel.booking.entity.UserEntity;
import com.hotel.booking.model.BookingModel;
import com.hotel.booking.repository.BookingRepository;
import com.hotel.booking.repository.HotelRepository;
import com.hotel.booking.repository.UserRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository book;

	@Autowired
	private HotelRepository hotel;

	@Autowired
	private UserRepository user;

	public Boolean addbooking(BookingModel b) {
		BookingEntity boo = new BookingEntity();

		Optional<HotelEntity> hotel_val = hotel.findById((Integer) b.getHotel_id());
		Optional<UserEntity> user_val = user.findById((Integer) b.getUser_id());
		if (hotel_val.isPresent() && user_val.isPresent()) {
			boo.setHotel(hotel_val.get());
			boo.setUser(user_val.get());
			boo.setStart_date(b.getStart_date());
			boo.setEnd_date(b.getEnd_date());
			boo.setTotal_amount(b.getTotal_amount());
			book.save(boo);
			return true;
		} else {
			return false;
		}
	}

}
