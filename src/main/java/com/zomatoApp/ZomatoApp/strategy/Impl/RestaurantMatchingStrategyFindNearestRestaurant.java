package com.zomatoApp.ZomatoApp.strategy.Impl;

import com.zomatoApp.ZomatoApp.dto.RestaurantDto;
import com.zomatoApp.ZomatoApp.entity.RequestOrder;
import com.zomatoApp.ZomatoApp.entity.Restaurant;
import com.zomatoApp.ZomatoApp.repository.RestaurantRepository;
import com.zomatoApp.ZomatoApp.strategy.RestaurantMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantMatchingStrategyFindNearestRestaurant implements RestaurantMatchingStrategy {

    private final RestaurantRepository restaurantRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<RestaurantDto> findRestaurant(RequestOrder order) {
        List<Restaurant> restaurants = restaurantRepository.findNearestRestaurant(order.getCurrentLocation());

        return restaurants.stream()
                .map(restaurant-> modelMapper.map(restaurant,RestaurantDto.class))
                .toList();
    }
}
