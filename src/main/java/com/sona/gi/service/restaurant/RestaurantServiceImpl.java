package com.sona.gi.service.restaurant;

import com.sona.gi.model.donation.mapper.DonationMapper;
import com.sona.gi.model.restaurant.dto.RestaurantDto;
import com.sona.gi.model.restaurant.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantMapper restaurantMapper;
    @Override
    public int regist(RestaurantDto restaurantDto) {
        return restaurantMapper.regist(restaurantDto);
    }

    @Override
    public List<RestaurantDto> findAll() {
        return restaurantMapper.findAll();
    }

    @Override
    public int modify(RestaurantDto restaurantDto) {
        return restaurantMapper.modify(restaurantDto);
    }

    @Override
    public int delete(RestaurantDto restaurantDto) {
        return restaurantMapper.delete(restaurantDto);
    }
}
