package com.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.booking.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query(value="select * from hotel_user where email=:email",nativeQuery = true)
	public UserEntity findByEmail(String email);

}
