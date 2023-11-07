package com.sona.gi.service.food;

import com.sona.gi.model.food.dto.FoodDto;

import java.util.List;

public interface FoodService {
    int regist(FoodDto foodDto);
    List<FoodDto> findAll();
    int modify(FoodDto foodDto);

    int delete(FoodDto foodDto);
}
