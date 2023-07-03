package com.hotel.booking.controller;

import java.util.HashMap;
import java.util.Map;

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
	public Map<String, String> send_otp(@RequestBody smsModel input) {
		System.out.println("sms will be sent for phone number : "+input.getPhone_number());
		Boolean checkFlag = otps.sendOtp(input);
		Map<String,String> resp = new HashMap<>();
		if(checkFlag) {
			resp.put("message", "OTP Sent Successfully");
			return resp;
		}
		else {
			resp.put("message","Something went wrong");
			return resp;
		}
	}
	
	@PostMapping("verify-phone")
	public Map<String,String> verify_otp(@RequestBody smsModel input) {
		System.out.println("otp entered : "+input.getOtp());
		Boolean checkFlag = otps.verifyOtp(input);
		Map<String,String> resp = new HashMap<>();
		if(checkFlag) {
			resp.put("message", "OTP Verified Successfully");
			return resp;
		}
		else {
			resp.put("message", "Invalid OTP");
			return resp;
		}
	}

}
