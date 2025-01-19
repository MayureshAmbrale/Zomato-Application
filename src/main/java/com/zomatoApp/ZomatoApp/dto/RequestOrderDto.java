package com.zomatoApp.ZomatoApp.dto;

import com.zomatoApp.ZomatoApp.entity.Order;
import com.zomatoApp.ZomatoApp.entity.Restaurant;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.geo.Point;

@Data
public class RequestOrderDto {
    private Long id;

    private Order order;

    private Restaurant restaurant;

    private Point currentLocation;
}
