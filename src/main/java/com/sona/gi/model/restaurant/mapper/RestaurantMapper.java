package com.sona.gi.model.restaurant.mapper;

import com.sona.gi.model.member.dto.MemberDto;
import com.sona.gi.model.restaurant.dto.RestaurantDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    int regist(RestaurantDto restaurantDto);
    List<RestaurantDto> findAll();
    int modify(RestaurantDto restaurantDto);

    int delete(RestaurantDto restaurantDto);
}
