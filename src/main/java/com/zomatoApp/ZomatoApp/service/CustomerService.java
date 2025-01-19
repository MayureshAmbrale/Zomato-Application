package com.zomatoApp.ZomatoApp.service;

import com.zomatoApp.ZomatoApp.dto.CustomerDto;
import com.zomatoApp.ZomatoApp.dto.OrderDto;
import com.zomatoApp.ZomatoApp.entity.Driver;
import com.zomatoApp.ZomatoApp.entity.Restaurant;

import java.util.List;

public interface CustomerService {

    OrderDto makeOrder(OrderDto order);
    OrderDto cancelOrder(Long orderId);
    List<OrderDto> getMyAllOrders();
    CustomerDto rateRestaurant(Restaurant restaurantId);
    CustomerDto rateDriver(Driver driverId);

}
