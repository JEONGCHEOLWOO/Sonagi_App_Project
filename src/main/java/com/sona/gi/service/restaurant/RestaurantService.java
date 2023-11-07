package com.sona.gi.service.restaurant;

import com.sona.gi.model.restaurant.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    int regist(RestaurantDto restaurantDto);
    List<RestaurantDto> findAll();
    int modify(RestaurantDto restaurantDto);

    int delete(RestaurantDto restaurantDto);
}
