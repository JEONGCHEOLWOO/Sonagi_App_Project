package com.sona.gi.service.foodReq;

import com.sona.gi.model.foodReq.dto.FoodReqDto;

import java.util.List;

public interface FoodReqService {

    int regist(FoodReqDto foodReqDto);
    List<FoodReqDto> findById(FoodReqDto foodReqDto);
    int delete(FoodReqDto foodReqDto);
    List<FoodReqDto> findBySenderId(FoodReqDto foodReqDto);
    int senderDelete(FoodReqDto foodReqDto);
}