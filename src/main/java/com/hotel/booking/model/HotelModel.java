package com.hotel.booking.model;

public class HotelModel {
	
	private Integer id;
	
	private String name;
	
	private String[] images = new String[0];
	
	private Integer rent;
	
	private String type;
	
	private Integer mxcount;
	
	private Long phNumber;
	
	private String[] bookingDetails;
	
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
