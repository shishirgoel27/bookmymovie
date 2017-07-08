package com.hw.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "seat")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Seat {

	public enum SeatStatus {
		available, unavailable
	}

	@Id
	@GeneratedValue
	private Long Id;

	private String seatNo;
	private Long cinemaHallId;
	private SeatStatus status = SeatStatus.available;

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public Long getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(Long cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Seat(String seatNo, Long cinemaHallId, String available) {
		super();
		this.seatNo = seatNo;
		this.cinemaHallId = cinemaHallId;
		this.status = SeatStatus.available.toString().equalsIgnoreCase(available) ? SeatStatus.available
				: SeatStatus.unavailable;
	}

}
