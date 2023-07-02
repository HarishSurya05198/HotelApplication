package com.hotel.booking.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.hotel.booking.model.smsModel;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class sendOtpService {

	public final static String SENDER_NUMBER = "+14847490412";

	public Boolean sendOtp(smsModel input) {
		try {
			String otp = generateOTP();
			String motp = "Dear user , OTP: " + otp + " is for verification of your account for Harish Booking Application.";
			Message msg = Message
					.creator(new PhoneNumber(input.getPhone_number()), new PhoneNumber(SENDER_NUMBER), motp).create();
			return true;
		} catch (Exception e) {
			System.out.println("[error] : "+e.getMessage());
			return false;
		}
	}

	private String generateOTP() {
		return new DecimalFormat("0000").format(new Random().nextInt(9999));
	}

}
