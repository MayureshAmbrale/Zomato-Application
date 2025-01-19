package com.zomatoApp.ZomatoApp.service;

import com.zomatoApp.ZomatoApp.dto.RestaurantDto;

public interface RestaurantService {
    RestaurantDto createRestaurant(RestaurantDto restaurantDto);
    RestaurantDto removeRestaurant(Long id );
}
