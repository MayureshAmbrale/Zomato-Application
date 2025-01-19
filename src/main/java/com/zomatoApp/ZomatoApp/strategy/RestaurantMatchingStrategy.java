package com.zomatoApp.ZomatoApp.strategy;

import com.zomatoApp.ZomatoApp.dto.RestaurantDto;
import com.zomatoApp.ZomatoApp.entity.RequestOrder;

import java.util.List;

public interface RestaurantMatchingStrategy {
    List<RestaurantDto> findRestaurant(RequestOrder order);
}
