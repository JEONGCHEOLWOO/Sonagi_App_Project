package com.sona.gi.service.restaurant;

import com.sona.gi.model.restaurant.dto.RestaurantDto;
import java.util.List;

public interface RestaurantService {
    int regist(RestaurantDto restaurantDto);
    List<RestaurantDto> findAll();
    int modifyPw(RestaurantDto restaurantDto);
    int delete(RestaurantDto restaurantDto);
    int findSearch(RestaurantDto restaurantDto);
    List<RestaurantDto> login(RestaurantDto restaurantDto);
    int addToken(RestaurantDto restaurantDto);
    int updateImageUrl(RestaurantDto restaurantDto);

    List<RestaurantDto> findById(RestaurantDto restaurantDto);
}
