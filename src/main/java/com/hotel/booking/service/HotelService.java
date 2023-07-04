package com.hotel.booking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.entity.BookingEntity;
import com.hotel.booking.entity.HotelEntity;
import com.hotel.booking.model.HotelModel;
import com.hotel.booking.repository.BookingRepository;
import com.hotel.booking.repository.HotelRepository;

@Service
public class HotelService {
	private final Logger logger = LoggerFactory.getLogger(HotelService.class);

	@Autowired
	private HotelRepository hotel;

	@Autowired
	private BookingRepository book;

	public Boolean addHotelRoom(HotelModel hotelVal) {
		HotelEntity e = new HotelEntity();
		try {
			e.setName(hotelVal.getName());
			e.setPhNumber(hotelVal.getPhNumber());
			e.setRent(hotelVal.getRent());
			e.setDesc(hotelVal.getDesc());
			e.setType(hotelVal.getType());
			e.setMxcount(hotelVal.getMxcount());
			e.setImages(hotelVal.getImages());
			e.setBookingDetails(hotelVal.getBookingDetails());
			hotel.save(e);
			return true;
		} catch (Exception exp) {
			return false;
		}
	}

	public List<HotelEntity> getAllHotels() {
		try {
			List<HotelEntity> list = hotel.findAll();
			Map<String,Object> obj = new LinkedHashMap<>();
			list.stream().forEach(i ->{
				obj.put(i.getId().toString(), i);
			});
			List<Integer> withDupes = Arrays.asList(10, 10, 20, 20, 30, 30, 40, 50);
			logger.info("with dupes {}",withDupes);
			List<Integer> withoutdupes = withDupes.stream().distinct().toList();
			logger.info("wtihout dupes {}",withoutdupes);
			logger.info("new obj {}",obj);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public List<HotelEntity> getHotels(String start, String end) {
		List<BookingEntity> b = book.findAll();
		List<HotelEntity> finalval = hotel.findAll();
		LocalDate st = LocalDate.parse(start);
		LocalDate en = LocalDate.parse(end);
		try {
		for (int i = 0; i < b.size(); i++) {
			LocalDate tempS = LocalDate.parse(b.get(i).getStart_date().toString());
			LocalDate tempE = LocalDate.parse(b.get(i).getEnd_date().toString());
			boolean case_a = st.isAfter(tempS) && st.isBefore(tempE);
			boolean case_b = en.isAfter(tempS) && en.isBefore(tempE);
			if (case_a == true || case_b == true) {
				for(int j=0;j<finalval.size();j++) {
					if(finalval.get(j).getId() == b.get(i).getHotel().getId()) {
						finalval.remove(j);
					}
				}
			}
		}
		return finalval;
		}
		catch (Exception e) {
			return null;
		}
	}
}
