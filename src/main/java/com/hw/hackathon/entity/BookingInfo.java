package com.hw.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "booking_info")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BookingInfo {

    public enum BookingStatus {
        confirmed, paid, failed, cancelled, other
    }

    @Id
    @GeneratedValue
    private Long Id;
    private Long cinemaHallId;
    private String userId;
    private Long paymentId;
    private Long movieId;
    private String seatNo;

	public String getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Long getCinemaHallId() {
		return cinemaHallId;
	}


	public void setCinemaHallId(Long cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


	public Long getMovieId() {
		return movieId;
	}


	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}


	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

//    private final Date timestamp = new Date();

    private BookingStatus bookingStatus;

    public BookingInfo() {
    }


    @JsonCreator
    public BookingInfo(@JsonProperty("Id") Long Id) {
        this.Id = Id;
    }

    public BookingInfo(String userId, Long cinemaHallId) {
        this.userId = userId;
        this.cinemaHallId = cinemaHallId;
        this.bookingStatus = BookingStatus.confirmed;
    }


    public BookingInfo( Long cinemaHallId, String userId, Long paymentId, String seatNo, Long movieId) {
        this.cinemaHallId = cinemaHallId;
        this.userId = userId;
        this.paymentId = paymentId;
        this.movieId = movieId;
        this.seatNo= seatNo;
        this.bookingStatus = BookingStatus.confirmed;
    }


}
