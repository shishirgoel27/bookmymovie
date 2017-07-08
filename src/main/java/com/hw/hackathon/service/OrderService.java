package com.hw.hackathon.service;

import java.util.List;

import com.hw.hackathon.dto.BookingInfoDto;
import com.hw.hackathon.entity.BookingInfo;

public interface OrderService {
    List<BookingInfo> saveOrdersByRestaurantId(String resterauntId, List<BookingInfo> orderInfos);
    List<BookingInfo> saveOrders(List<BookingInfo> orderInfos);
    List<BookingInfo> viewOrders(String resterauntId);
    BookingInfo findFirstByOrderId(String orderId);
    void deleteOrder(String orderId);
    void purge();

    BookingInfoDto viewOrderConfirmation(String orderId);

    void updateOrderStatus(String orderId, BookingInfo.BookingStatus orderStatus);
}
