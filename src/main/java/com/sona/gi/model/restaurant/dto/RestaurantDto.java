package com.sona.gi.model.restaurant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDto {

    //음식점 DTO

    private String id;
    private String password;
    private String name;
    private String phoneNum;
    private String adTel;
    private String adName;
    private String address;

    //사업자 등록 번호
    private String bNum;

    
}
