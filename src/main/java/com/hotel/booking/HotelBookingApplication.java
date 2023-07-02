package com.hotel.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;

@SpringBootApplication
public class HotelBookingApplication {
	
	public final static String ACCOUNT_ID = "AC0897ff7987f0f4c891968966cc393b61";
	public final static String AUTH_TOKEN = "659e93845f9dc903ba794bc126a06ff5";
	
	public static void main(String[] args) {
		Twilio.init(ACCOUNT_ID, AUTH_TOKEN);
		SpringApplication.run(HotelBookingApplication.class, args);
	}

}
