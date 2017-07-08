package com.hw.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "payment_info")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentInfo {
	@Id
	@GeneratedValue
	private Long Id;
	
	private Long bookingId;
	
	private double amount;


	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public PaymentInfo(Long bookingId, double amount) {
		this.bookingId = bookingId;
		this.amount=amount;
	}

}
