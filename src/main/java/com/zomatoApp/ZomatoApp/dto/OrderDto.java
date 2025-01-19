package com.zomatoApp.ZomatoApp.dto;

import com.zomatoApp.ZomatoApp.entity.Delivery;
import com.zomatoApp.ZomatoApp.entity.Restaurant;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long id;

    private Delivery delivery;
    private List<String> menu;
//    private Restaurant restaurant;
    private PointDto point;
}
