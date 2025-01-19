package com.zomatoApp.ZomatoApp.controller;

import com.zomatoApp.ZomatoApp.dto.RestaurantDto;
import com.zomatoApp.ZomatoApp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("create")
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto)
    {
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurantDto));
    }
    @PostMapping("remove/{id}")
    public ResponseEntity<RestaurantDto> removeRestaurant(@PathVariable Long id )
    {
        return ResponseEntity.ok(restaurantService.removeRestaurant(id));
    }
}
