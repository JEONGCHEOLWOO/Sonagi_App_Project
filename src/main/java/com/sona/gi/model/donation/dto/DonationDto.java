package com.sona.gi.model.donation.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
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


}
