package com.hw.hackathon.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hw.hackathon.dto.BookingInfoDto;
import com.hw.hackathon.entity.*;
import com.hw.hackathon.repository.MovieRepository;
import com.hw.hackathon.repository.BookingRepository;
import com.hw.hackathon.service.OrderService;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private BookingRepository orderRepository;
    private MovieRepository itemRepository;

    @Autowired
    public OrderServiceImpl(BookingRepository orderRepository, MovieRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<BookingInfo> saveOrdersByRestaurantId(String restaurantId, List<BookingInfo> orderInfos){
        for(BookingInfo orderInfo: orderInfos){
            orderInfo.setRestaurantId(restaurantId);
        }
        return orderRepository.save(orderInfos);
    }

    @Override
    public List<BookingInfo> saveOrders(List<BookingInfo> orderInfos) {
        return orderRepository.save(orderInfos);
    }

    @Override
    public void purge(){
        orderRepository.deleteAll();
    }

    @Override
    public List<BookingInfo> viewOrders(String restaurantId){
        return orderRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public BookingInfo findFirstByOrderId(String orderId) {
        return orderRepository.findFirstByOrderId(orderId);
    }

    @Override
    public void deleteOrder(String orderId){
        orderRepository.deleteByOrderId(orderId);
    }

    @Override
    public BookingInfoDto viewOrderConfirmation(String orderId) {

        BookingInfo orderInfo = orderRepository.findFirstByOrderId(orderId);
        BookingInfoDto orderInfoDto = new BookingInfoDto(orderInfo);
        if(orderInfoDto.getOrderStatus().equals(BookingInfo.BookingStatus.paid)){
            orderInfoDto.setDeliveryTime(new Random().nextInt(55)+5);
        }
        log.info("using orderInfoDto to view order for Id:" + orderId + " deliverytime:" + orderInfoDto.getDeliveryTime());
        List<CinemaHall> itemList = itemRepository.findByOrderInfo(orderInfo);
        orderInfoDto.setItemList(itemList);
        double totPrice = 0.0;
        for(CinemaHall item: itemList ) {
            totPrice += item.getPrice() * item.getQuantity();
        }
        orderInfoDto.setPrice(totPrice);
        return orderInfoDto;
    }

    @Override
    public void updateOrderStatus(String orderId, BookingInfo.BookingStatus orderStatus){
	System.out.println("order service handling update BookingStatus to" + orderStatus + "of orderId: " + orderId);
        BookingInfo orderInfo = findFirstByOrderId(orderId);
        orderInfo.setOrderStatus(orderStatus);
        orderRepository.save(orderInfo);
    }
}
