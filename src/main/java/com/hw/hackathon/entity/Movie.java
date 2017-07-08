package com.hw.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "movie")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Movie {
	@Id
	@GeneratedValue
	private Long Id;

	private String name;
	private Long cinemaHallId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Movie(String name, Long cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
		this.name=name;
	}

}
