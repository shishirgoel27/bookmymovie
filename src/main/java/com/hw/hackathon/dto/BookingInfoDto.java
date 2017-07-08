package com.hw.hackathon.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hw.hackathon.entity.BookingInfo;
import com.hw.hackathon.entity.CinemaHall;
import com.hw.hackathon.entity.BookingInfo.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingInfoDto {
    private String restaurantName;
    private String userId;
    private int deliveryTime;
    private String deliveryAddress;
    private String notes;
    private String orderId;
    private double price;
    private List<CinemaHall> itemList = new ArrayList<>();
    private BookingInfo.BookingStatus orderStatus;
            //= new ArrayList<>();


    public BookingInfoDto(BookingInfo orderInfo) {
        this.userId = orderInfo.getUserId();
        this.deliveryAddress = orderInfo.getDeliveryAddress();
        this.notes = orderInfo.getNotes();
        this.orderId = orderInfo.getOrderId();
        this.restaurantName = orderInfo.getRestaurantName();
        this.orderStatus = orderInfo.getOrderStatus();
        this.price = 0.0;
    }
}
