package com.zomatoApp.ZomatoApp.strategy.Impl;

import com.zomatoApp.ZomatoApp.dto.RestaurantDto;
import com.zomatoApp.ZomatoApp.entity.RequestOrder;
import com.zomatoApp.ZomatoApp.repository.RestaurantRepository;
import com.zomatoApp.ZomatoApp.strategy.RestaurantMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantMatchingStrategyFindByRating implements RestaurantMatchingStrategy {
    private final RestaurantRepository restaurantRepository;
    @Override
    public List<RestaurantDto> findRestaurant(RequestOrder order) {
        return restaurantRepository.findRestaurantBasedOnRating(order.getCurrentLocation());

    }
}
