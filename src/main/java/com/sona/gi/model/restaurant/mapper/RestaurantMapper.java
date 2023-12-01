package com.sona.gi.model.restaurant.mapper;

import com.sona.gi.model.restaurant.dto.RestaurantDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {
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
