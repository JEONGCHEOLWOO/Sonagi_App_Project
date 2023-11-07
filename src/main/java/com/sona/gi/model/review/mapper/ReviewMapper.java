package com.sona.gi.model.review.mapper;

import com.sona.gi.model.restaurant.dto.RestaurantDto;
import com.sona.gi.model.review.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    int regist(ReviewDto reviewDto);
    List<ReviewDto> findAll();
    int modify(ReviewDto reviewDto);

    int delete(ReviewDto reviewDto);
}
