package com.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.booking.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer>{

}
