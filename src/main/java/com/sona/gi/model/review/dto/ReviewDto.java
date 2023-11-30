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
    private String donator;
    private String receiver;
    private Date reviewDate;
    private String reviewImage;

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

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getDonator() {
        return donator;
    }

    public void setDonator(String donator) {
        this.donator = donator;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReviewImage() {
        return reviewImage;
    }

    public void setReviewImage(String reviewImage) {
        this.reviewImage = reviewImage;
    }
}
