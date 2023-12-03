package com.sona.gi.model.foodReq.mapper;

import com.sona.gi.model.foodReq.dto.FoodReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodReqMapper {

    int regist(FoodReqDto foodReqDto);

    List<FoodReqDto> findById(FoodReqDto foodReqDto);

    int delete(FoodReqDto foodReqDto);

    List<FoodReqDto> findBySenderId(FoodReqDto foodReqDto);

    int senderDelete(FoodReqDto foodReqDto);
}