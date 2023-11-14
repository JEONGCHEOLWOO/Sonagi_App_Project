package com.sona.gi.model.donation.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


public class DonationDto {

    //기부내역 DTO

    //기부한 날짜
    private Date donatedDate;

    //기부한 사람
    private String donatedProvider;

    //기부 받은 사람
    private String donatedReceiver;

    //몇인분 기부했는지
    private String donatedAmount;

    //총 기부한 금액
    private String donatedPrice;

    //리뷰 썼는지 안썼는지 체크
    private boolean isReviewed;

    public Date getDonatedDate() {
        return donatedDate;
    }

    public void setDonatedDate(Date donatedDate) {
        this.donatedDate = donatedDate;
    }

    public String getDonatedProvider() {
        return donatedProvider;
    }

    public void setDonatedProvider(String donatedProvider) {
        this.donatedProvider = donatedProvider;
    }

    public String getDonatedReceiver() {
        return donatedReceiver;
    }

    public void setDonatedReceiver(String donatedReceiver) {
        this.donatedReceiver = donatedReceiver;
    }

    public String getDonatedAmount() {
        return donatedAmount;
    }

    public void setDonatedAmount(String donatedAmount) {
        this.donatedAmount = donatedAmount;
    }

    public String getDonatedPrice() {
        return donatedPrice;
    }

    public void setDonatedPrice(String donatedPrice) {
        this.donatedPrice = donatedPrice;
    }

    public boolean isReviewed() {
        return isReviewed;
    }

    public void setReviewed(boolean reviewed) {
        isReviewed = reviewed;
    }
}
