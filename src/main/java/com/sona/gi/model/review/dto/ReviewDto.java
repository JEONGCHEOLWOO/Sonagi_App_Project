package com.sona.gi.model.review.dto;

import java.sql.Date;


public class ReviewDto {

    //리뷰 DTO

    //지역 카테고리
    private String regionCategory;

    //리뷰 제목
    private String reviewTitle;
    //리뷰 내용
    private String reviewContext;

    private String writer;

    private Date reviewDate;

    public String getRegionCategory() {
        return regionCategory;
    }

    public void setRegionCategory(String regionCategory) {
        this.regionCategory = regionCategory;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewContext() {
        return reviewContext;
    }

    public void setReviewContext(String reviewContext) {
        this.reviewContext = reviewContext;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
