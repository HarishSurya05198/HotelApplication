package com.hotel.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.booking.entity.UserEntity;
import com.hotel.booking.model.UserModel;
import com.hotel.booking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository us;

	public boolean addUser(UserModel u) {
		try {
			UserEntity users = new UserEntity();
			UserEntity check = us.findByEmail(u.getEmail());
			if (check == null) {
				users.setName(u.getName());
				users.setEmail(u.getEmail());
				users.setPassword(u.getPassword());
				us.save(users);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public UserEntity loginUser(UserModel u) {
		try {
			UserEntity users = new UserEntity();
			UserEntity resp = null;
			users.setEmail(u.getEmail());
			resp = us.findByEmail(users.getEmail());
			return resp;
		} catch (Exception e) {
			return null;
		}

	}

}
