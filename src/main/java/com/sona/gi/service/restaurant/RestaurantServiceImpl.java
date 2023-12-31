package com.sona.gi.service.restaurant;

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
    public int regist(RestaurantDto restaurantDto) { return restaurantMapper.regist(restaurantDto); }

    @Override
    public List<RestaurantDto> findAll() {
        return restaurantMapper.findAll();
    }

    @Override
    public int modifyPw(RestaurantDto restaurantDto) { return restaurantMapper.modifyPw(restaurantDto); }

    @Override
    public int delete(RestaurantDto restaurantDto) {
        return restaurantMapper.delete(restaurantDto);
    }

    @Override
    public int findSearch(RestaurantDto restaurantDto) { return restaurantMapper.findSearch(restaurantDto); }

    @Override
    public List<RestaurantDto> login(RestaurantDto restaurantDto) { return restaurantMapper.login(restaurantDto); }

    @Override
    public int addToken(RestaurantDto restaurantDto) {
        System.out.println(restaurantDto.getId());
        System.out.println(restaurantDto.getExpotoken());



        return restaurantMapper.addToken(restaurantDto);
    }

    @Override
    public int updateImageUrl(RestaurantDto restaurantDto) { return restaurantMapper.updateImageUrl(restaurantDto); }

    @Override
    public List<RestaurantDto> findById(RestaurantDto restaurantDto) { return restaurantMapper.findById(restaurantDto); }
}
