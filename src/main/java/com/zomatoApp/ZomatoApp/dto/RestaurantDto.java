package com.zomatoApp.ZomatoApp.dto;

import com.zomatoApp.ZomatoApp.entity.Delivery;
import com.zomatoApp.ZomatoApp.entity.Order;
import com.zomatoApp.ZomatoApp.enums.RestaurantStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.geo.Point;

import java.util.List;

@Data
public class RestaurantDto {
    private Long id;

    private String name;

    private Delivery delivery;

//    private List<Order> orders;

    private Double rating ;

    private PointDto restaurantLocation;

    private Boolean open;
}
