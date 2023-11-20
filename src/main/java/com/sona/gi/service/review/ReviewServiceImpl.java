package com.sona.gi.service.review;

import com.sona.gi.model.review.dto.ReviewDto;
import com.sona.gi.model.review.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewMapper reviewMapper;
    @Override
    public int regist(ReviewDto reviewDto) {
        return reviewMapper.regist(reviewDto);
    }

    @Override
    public List<ReviewDto> findAll() {
        return reviewMapper.findAll();
    }

    @Override
    public int modify(ReviewDto reviewDto) {
        return reviewMapper.modify(reviewDto);
    }

    @Override
    public int delete(ReviewDto reviewDto) {
        return reviewMapper.delete(reviewDto);
    }
}
