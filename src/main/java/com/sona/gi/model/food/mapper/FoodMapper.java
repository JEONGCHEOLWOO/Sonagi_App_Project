package com.sona.gi.model.food.mapper;

import com.sona.gi.model.donation.dto.DonationDto;
import com.sona.gi.model.food.dto.FoodDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {
    int regist(FoodDto foodDto);
    List<FoodDto> findAll();
    int modify(FoodDto foodDto);

    int delete(FoodDto foodDto);
}
