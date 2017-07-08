package com.hw.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "price_info")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PriceInfo {
	@Id
	@GeneratedValue
	private Long Id;

	private Long hallId;
	private double price;

	public Long getHallId() {
		return hallId;
	}

	public void setHallId(Long hallId) {
		this.hallId = hallId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public PriceInfo(Long hallId, double price) {
		this.hallId = hallId;
		this.price=price;
	}

}
