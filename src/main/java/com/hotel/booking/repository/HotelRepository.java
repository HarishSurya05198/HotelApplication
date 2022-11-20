package com.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.booking.entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer>{

}
