package com.zomatoApp.ZomatoApp.repository;

import com.zomatoApp.ZomatoApp.dto.RestaurantDto;
import com.zomatoApp.ZomatoApp.entity.Restaurant;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "SELECT R.*,ST_Distance(R.restaurant_location,:orderLocation) AS distance " +
            "FROM RESTAURANT R "+
            "WHERE R.open = true and ST_DWithin(r.restaurant_location, :orderLocation, 10000) "+
            "ORDER BY distance "+
            "LIMIT 10 ",nativeQuery = true
    )
    List<Restaurant> findNearestRestaurant(Point orderLocation);

    @Query(value = "SELECT R.* " +
            "FROM RESTAURANT R "+
            "WHERE R.open = true and ST_DWithin(r.restaurant_location, :currentLocation, 10000) "+
            "ORDER BY R.rating DESC "+
            "LIMIT 10 ",nativeQuery = true
    )
    List<RestaurantDto> findRestaurantBasedOnRating(Point currentLocation);
}
