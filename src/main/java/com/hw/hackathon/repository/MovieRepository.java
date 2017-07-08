package com.hw.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hw.hackathon.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
//    List<Movie> findByCinemaHallId(String cinemaHallId);
   Movie findByName(String name);
}
