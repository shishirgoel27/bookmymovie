package com.hw.hackathon.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hw.hackathon.dto.BookingInfoDto;
import com.hw.hackathon.entity.BookingInfo;
import com.hw.hackathon.service.OrderService;

import java.util.List;

@RestController
public class BookingRestController {

    private OrderService orderService;

    @Autowired
    public BookingRestController(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping(value = "/restaurant/{restaurantId}/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<BookingInfo> saveOrdersByRestaurantId(@PathVariable String restaurantId, @RequestBody List<BookingInfo> orderInfos) {
        return orderService.saveOrdersByRestaurantId(restaurantId, orderInfos);
    }

    @RequestMapping(value = "/restaurant/order", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.CREATED)
    public void purge() {
        orderService.purge();
    }

    @RequestMapping(value = "/restaurant/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<BookingInfo> saveOrders(@RequestBody List<BookingInfo> orderInfos) {
        return orderService.saveOrders(orderInfos);
    }

    @RequestMapping(value = "/restaurant/order", method = RequestMethod.GET)
    public String orderGreetings() {
        return "Welcome to order root page!";
    }

    @RequestMapping(value = "/restaurant/{restaurantId}/order", method = RequestMethod.GET)
    public List<BookingInfo> viewOrders(@PathVariable String restaurantId) {
        return orderService.viewOrders(restaurantId);
    }

    @RequestMapping(value = "/restaurant/order/{orderId}", method = RequestMethod.GET)
    public BookingInfoDto viewOrderConfirmation(@PathVariable String orderId) {
        // first check current order status
        BookingInfoDto orderInfoDto = orderService.viewOrderConfirmation(orderId);
        return orderInfoDto;
    }

    @RequestMapping(value = "/restaurant/order/{orderId}", method = RequestMethod.PUT)
    public void updateOrderStatus(@PathVariable String orderId,@RequestBody BookingInfo orderInfo){
        BookingInfo.BookingStatus orderStatus = orderInfo.getOrderStatus();
        BookingInfo orderInfo1 = orderService.findFirstByOrderId(orderId);
        //System.out.println("order service handling put request on path:/restaurant/order/" + orderId +
        //        ", original status is:" + orderInfo1.getOrderStatus() +
         //       ", target orderstatus is"+ orderStatus);
        orderService.updateOrderStatus(orderId, orderStatus);
        System.out.println("new BookingInfo status is:" + orderInfo1.getOrderStatus());
    }


    @RequestMapping(value = "/restaurant/order/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
    }

}
