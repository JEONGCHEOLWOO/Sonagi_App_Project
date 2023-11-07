package com.sona.gi.model.review.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ReviewDto {

    //리뷰 DTO

    //지역 카테고리
    private String regionCategory;

    //리뷰 제목
    private String reviewTitle;
    //리뷰 내용
    private String reviewContext;

    private String image;

    private String writer;

    private Date reviewDate;

}
