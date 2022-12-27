package com.hotel.booking.model;

import java.sql.Date;

import javax.persistence.Id;

import org.springframework.lang.NonNull;

public class BookingModel {
	
	@Id
	private Integer id;
	
	private Date start_date;
	
	private Date end_date;

	@NonNull
	private Integer user_id;
	
	@NonNull
	private Integer hotel_id;
	
	private Integer total_amount;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(@NonNull Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(@NonNull Integer hotel_id) {
		this.hotel_id = hotel_id;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}
	
	

	
}
