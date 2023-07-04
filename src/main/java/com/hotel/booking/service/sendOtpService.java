package com.hotel.booking.service;

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.entity.OneTimeEntity;
import com.hotel.booking.model.smsModel;
import com.hotel.booking.repository.OneTimeRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class sendOtpService {

	@Autowired
	private OneTimeRepository otpsave;

	public final static String SENDER_NUMBER = "+14847490412";

	public Boolean sendOtp(smsModel input) {
		try {
			String otp = generateOTP();
			String phone_number = "+91" + input.getPhone_number();
			String motp = "Dear user , OTP: " + otp
					+ " is for verification of your account for Harish Booking Application.";
			String key = keygen(input.getPhone_number());
			OneTimeEntity otpval = null;
			Optional<OneTimeEntity> temp_val = otpsave.findByKey(key);
			if (temp_val.isPresent()) {
				otpval = temp_val.get();
				otpval.setOtpval(otp);
			} else {
				otpval = new OneTimeEntity();
				otpval.setKey(key);
				otpval.setOtpval(otp);
			}
			otpsave.save(otpval);
			Message msg = Message.creator(new PhoneNumber(phone_number), new PhoneNumber(SENDER_NUMBER), motp).create();
			return true;
		} catch (Exception e) {
			System.out.println("[error] : " + e.getMessage());
			return false;
		}
	}

	private String keygen(String number) {
		return "hotel-booking-" + number + "-otp";
	}

	private String generateOTP() {
		return new DecimalFormat("0000").format(new Random().nextInt(9999));
	}

	public Boolean verifyOtp(smsModel input) {
		String key = keygen(input.getPhone_number());
		Optional<OneTimeEntity> otpver_temp = otpsave.findByKey(key);
		if (otpver_temp.isPresent()) {
			OneTimeEntity otpval = otpver_temp.get();
			if (otpval.getOtpval().equals(input.getOtp())) {
				otpval.setOtpval(null);
				otpsave.save(otpval);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
