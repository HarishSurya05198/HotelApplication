package com.hotel.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="hotels")
@Entity
public class HotelEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="imageUrls")
	private String[] images = new String[0];
	
	@Column(name="rentPerDay")
	private Integer rent;
	
	@Column(name="type")
	private String type;
	
	@Column(name="maxCount")
	private Integer mxcount;
	
	@Column(name="phoneNumber")
	private Long phNumber;
	
	@Column(name="currentBookings")
	private String[] bookingDetails = new String[0];
	
	@Column(name="description")
	private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMxcount() {
		return mxcount;
	}

	public void setMxcount(Integer mxcount) {
		this.mxcount = mxcount;
	}

	public Long getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(Long phNumber) {
		this.phNumber = phNumber;
	}

	public String[] getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(String[] bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
