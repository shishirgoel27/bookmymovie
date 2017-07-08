package com.hw.hackathon.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "cinema_hall")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CinemaHall {
	@Id
	@GeneratedValue
	private Long Id;

	private Long movieId;
	private int numSeats;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cinemaHallId")
	private List<BookingInfo> bookingInfoList;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public CinemaHall(Long movieId, int numSeats) {
		this.movieId = movieId;
		this.numSeats=numSeats;
	}

}
