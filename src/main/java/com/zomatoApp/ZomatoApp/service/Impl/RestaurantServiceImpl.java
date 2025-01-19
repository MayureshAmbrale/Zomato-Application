package com.zomatoApp.ZomatoApp.service.Impl;

import com.zomatoApp.ZomatoApp.dto.RestaurantDto;
import com.zomatoApp.ZomatoApp.entity.Restaurant;
import com.zomatoApp.ZomatoApp.repository.RestaurantRepository;
import com.zomatoApp.ZomatoApp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ModelMapper modelMapper;
    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = modelMapper.map(restaurantDto,Restaurant.class);
        restaurant.setRating(4.9);
        restaurant.setOpen(true);
         Restaurant saved =restaurantRepository.save(restaurant);


        return modelMapper.map(saved,RestaurantDto.class);
    }

    @Override
    public RestaurantDto removeRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                "No Restaurant with id :"+id
        ));
        restaurant.setOpen(false);
        RestaurantDto restaurantDto = modelMapper.map(restaurant,RestaurantDto.class);
        restaurantRepository.deleteById(id);
        return restaurantDto;
    }
}
