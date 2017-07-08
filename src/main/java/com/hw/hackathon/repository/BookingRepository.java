package com.hw.hackathon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hw.hackathon.entity.BookingInfo;

public interface BookingRepository extends CrudRepository<BookingInfo, Long> {
	
	List<BookingInfo> findByCinemaHallId(Long cinemaHallId);
}
