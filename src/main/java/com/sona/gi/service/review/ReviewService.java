package com.sona.gi.service.review;

import com.sona.gi.model.review.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    int regist(ReviewDto reviewDto);
    List<ReviewDto> findAll();
    int modify(ReviewDto reviewDto);

    int delete(ReviewDto reviewDto);
}
