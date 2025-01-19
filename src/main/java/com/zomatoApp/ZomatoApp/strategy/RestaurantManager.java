package com.zomatoApp.ZomatoApp.strategy;

import com.zomatoApp.ZomatoApp.strategy.Impl.RestaurantMatchingStrategyFindByRating;
import com.zomatoApp.ZomatoApp.strategy.Impl.RestaurantMatchingStrategyFindNearestRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantManager {
    private final RestaurantMatchingStrategyFindNearestRestaurant restaurantMatchingStrategyFindNearestRestaurant;
    private final RestaurantMatchingStrategyFindByRating restaurantMatchingStrategyFindByRating;

    public RestaurantMatchingStrategy restaurantMatchingStrategy(double rating)
    {
        if(rating >= 4.8)
        {
            return restaurantMatchingStrategyFindByRating;
        }
        else
            return restaurantMatchingStrategyFindNearestRestaurant;
    }

}
