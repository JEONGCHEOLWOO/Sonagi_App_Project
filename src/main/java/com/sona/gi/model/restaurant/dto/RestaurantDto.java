package com.sona.gi.model.restaurant.dto;

import lombok.Getter;
import lombok.Setter;


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

    private String profileImage;

    private String expotoken;
    private String fcmtoken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAdTel() {
        return adTel;
    }

    public void setAdTel(String adTel) {
        this.adTel = adTel;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getbNum() {
        return bNum;
    }

    public void setbNum(String bNum) {
        this.bNum = bNum;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getExpotoken() {
        return expotoken;
    }

    public void setExpotoken(String expotoken) {
        this.expotoken = expotoken;
    }

    public String getFcmtoken() {
        return fcmtoken;
    }

    public void setFcmtoken(String fcmtoken) {
        this.fcmtoken = fcmtoken;
    }
}
