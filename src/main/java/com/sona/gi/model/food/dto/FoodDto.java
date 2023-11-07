package com.sona.gi.model.food.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDto {

    //기부할 음식 등록

    //음식 이름
    private String foodName;

    //총 몇인분
    private String foodAmount;

    //1인분당 음식 가격
    private String foodPrice;

    //가게 전화번호
    private String foodTel;

    //가게 주소
    private String foodAddress;

    //가게 이름
    private String foodGiver;

}
