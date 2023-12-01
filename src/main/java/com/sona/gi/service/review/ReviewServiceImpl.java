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

    @Override
    public int updateImageUrl(ReviewDto reviewDto) { return reviewMapper.updateImageUrl(reviewDto); }

    @Override
    public List<ReviewDto> findByIdD(ReviewDto reviewDto) { return reviewMapper.findByIdD(reviewDto); }

    @Override
    public List<ReviewDto> findByIdR(ReviewDto reviewDto) { return reviewMapper.findByIdR(reviewDto); }
}
