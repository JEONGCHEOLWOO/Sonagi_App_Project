package com.sona.gi.service.food;

import com.sona.gi.model.donation.mapper.DonationMapper;
import com.sona.gi.model.food.dto.FoodDto;
import com.sona.gi.model.food.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public int regist(FoodDto foodDto) {
        return foodMapper.regist(foodDto);
    }

    @Override
    public List<FoodDto> findAll() {
        return foodMapper.findAll();
    }

    @Override
    public int modify(FoodDto foodDto) {
        return foodMapper.modify(foodDto);
    }

    @Override
    public int delete(FoodDto foodDto) {
        return foodMapper.delete(foodDto);
    }
}
