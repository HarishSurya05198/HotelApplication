package com.hotel.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.model.smsModel;
import com.hotel.booking.service.sendOtpService;

@RestController
@RequestMapping(value="api/otp/")
public class smsController {
	
	@Autowired
	sendOtpService otps;
	
	@PostMapping("send-phone")
	public String send_otp(@RequestBody smsModel input) {
		System.out.println("sms will be sent for phone number : "+input.getPhone_number());
		Boolean checkFlag = otps.sendOtp(input);
		if(checkFlag) {
			return "OTP Sent Successfully";
		}
		else {
			return "Something went wrong";
		}
	}
	
	@PostMapping("verify-phone")
	public String verify_otp(@RequestBody smsModel input) {
		System.out.println("otp entered : "+input.getOtp());
		Boolean checkFlag = otps.verifyOtp(input);
		if(checkFlag) {
			return "OTP Verified Successfully";
		}
		else {
			return "Invalid OTP";
		}
	}

}
