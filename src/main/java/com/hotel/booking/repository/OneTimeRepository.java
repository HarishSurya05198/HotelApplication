package com.hotel.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.booking.entity.OneTimeEntity;

public interface OneTimeRepository extends JpaRepository<OneTimeEntity, Integer> {
	
	Optional<OneTimeEntity> findByKey(String key);

}
