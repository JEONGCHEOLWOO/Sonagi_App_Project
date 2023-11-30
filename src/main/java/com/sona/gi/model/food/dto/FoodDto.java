package com.sona.gi.model.food.dto;


public class FoodDto {

    //기부할 음식 등록
    private String id;
    //음식 이름
    private String foodName;
    //총 몇인분
    private String foodAmount;
    //1인분당 음식 가격
    private int foodPrice;
    //가게 전화번호
    private String foodTel;
    //가게 주소
    private String foodAddress;
    //가게 이름
    private String foodGiver;
    // 음식 이미지
    private String foodImage;
    // 음식 업로드 시간
    private String foodUploadTime;
    // 음식 설명
    private String context;
    // 음식 조리 완료 시간
    private String cookingTime;

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

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
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

    public String getFoodUploadTime() {
        return foodUploadTime;
    }

    public void setFoodUploadTime(String foodUploadTime) {
        this.foodUploadTime = foodUploadTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }
}
