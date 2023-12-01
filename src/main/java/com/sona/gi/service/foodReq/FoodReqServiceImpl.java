package com.sona.gi.service.foodReq;

import com.sona.gi.model.foodReq.dto.FoodReqDto;
import com.sona.gi.model.foodReq.mapper.FoodReqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodReqServiceImpl implements FoodReqService{

    @Autowired
    private FoodReqMapper foodReqMapper;
    @Override
    public int regist(FoodReqDto foodReqDto) {
        return foodReqMapper.regist(foodReqDto);
    }
    @Override
    public List<FoodReqDto> findById(FoodReqDto foodReqDto) {
        return foodReqMapper.findById(foodReqDto);
    }
    @Override
    public int delete(FoodReqDto foodReqDto) {
        return foodReqMapper.delete(foodReqDto);
    }

}