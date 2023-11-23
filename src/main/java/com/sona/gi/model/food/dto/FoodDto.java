package com.sona.gi.model.food.dto;


public class FoodDto {

    //기부할 음식 등록

    private String id;
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

    private String foodImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(String foodAmount) {
        this.foodAmount = foodAmount;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodTel() {
        return foodTel;
    }

    public void setFoodTel(String foodTel) {
        this.foodTel = foodTel;
    }

    public String getFoodAddress() {
        return foodAddress;
    }

    public void setFoodAddress(String foodAddress) {
        this.foodAddress = foodAddress;
    }

    public String getFoodGiver() {
        return foodGiver;
    }

    public void setFoodGiver(String foodGiver) {
        this.foodGiver = foodGiver;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }
}
