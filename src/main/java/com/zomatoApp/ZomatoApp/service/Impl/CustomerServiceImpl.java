package com.zomatoApp.ZomatoApp.service.Impl;

import com.zomatoApp.ZomatoApp.dto.CustomerDto;
import com.zomatoApp.ZomatoApp.dto.OrderDto;
import com.zomatoApp.ZomatoApp.entity.*;
import com.zomatoApp.ZomatoApp.repository.OrderRepository;
import com.zomatoApp.ZomatoApp.repository.RequestOrderRepository;
import com.zomatoApp.ZomatoApp.repository.RestaurantRepository;
import com.zomatoApp.ZomatoApp.service.CustomerService;
import com.zomatoApp.ZomatoApp.strategy.Impl.RestaurantMatchingStrategyFindNearestRestaurant;
import com.zomatoApp.ZomatoApp.strategy.RestaurantManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final RequestOrderRepository requestOrderRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final RestaurantManager restaurantManager;
    private  final RestaurantRepository restaurantRepository;
    private final RestaurantMatchingStrategyFindNearestRestaurant findNearestRestaurant;
    @Override
    @Transactional
    public OrderDto makeOrder(OrderDto orderDto) {
// TODO use current user as customer in order
        Order order = modelMapper.map(orderDto, Order.class);
        Order savedOrder1 = orderRepository.save(order);

        RequestOrder requestOrder = requestOrderRepository.findById(savedOrder1.getId())
                .orElse(new RequestOrder());
        requestOrder.setOrder(order);

//        if(orderDto.getRestaurant() == null)
//        {
//            List<RestaurantDto> restaurantDto = findNearestRestaurant
//                    .findRestaurant(requestOrder);
//
//            RestaurantDto restaurantDto1 = restaurantDto.stream()
//                    .findFirst()
//                    .orElse(null);
//            if(restaurantDto1 == null)
//            {
                List<Restaurant> restaurant = restaurantRepository.findAll();

                Restaurant restaurant1 = restaurant.stream()
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("No available restaurants"));

//            }
//            else
//                order.setRestaurant(modelMapper.map(restaurantDto1,Restaurant.class));


//            requestOrder.setRestaurant(modelMapper.map(restaurantDto1,Restaurant.class));
        requestOrder.setRestaurant(restaurant1);
//        }
//        else
//        {
//            requestOrder.setRestaurant(orderDto.getRestaurant());
//        }
//        requestOrder.setRestaurant(modelMapper.map(restaurantDto1,Restaurant.class));
        Order savedOrder = orderRepository.save(order);
        requestOrderRepository.save(requestOrder);
        return modelMapper.map(savedOrder, OrderDto.class);

    }

    @Override
    public OrderDto cancelOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new NoSuchElementException("No order present with id "+orderId ));

        orderRepository.deleteById(orderId);

        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public List<OrderDto> getMyAllOrders() {

        Customer customer= getCurrentCustomer();
        List<Order> orders = orderRepository.findByCustomer(customer);

        return null;
    }

    @Override
    public CustomerDto rateRestaurant(Restaurant restaurantId) {
        return null;
    }

    @Override
    public CustomerDto rateDriver(Driver driverId) {
        return null;
    }
    public Customer getCurrentCustomer()
    {
        //TODO create Customer using SecurityContextHolder
        Customer customer = Customer.builder()
                .id(1L)
                .build();
        return null;
    }
}
