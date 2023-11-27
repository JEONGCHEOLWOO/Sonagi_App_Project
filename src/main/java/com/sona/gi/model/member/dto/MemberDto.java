package com.sona.gi.model.member.dto;

public class MemberDto {

    //보육원 DTO

    private String id; //primary key
    private String password;
    //보육원 이름
    private String adName;
    //시설 전화번호
    private String adTel;
    //시설장 이름
    private String managerName;
    //개인 전화번호
    private String phoneNum;

    private String address;

    //총 인원수 (HC : head count)
    private int totalHc;

    //현재 인원수
    private int currHc;

    private String introduction;

    private String profileImage;

    private String token;

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

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdTel() {
        return adTel;
    }

    public void setAdTel(String adTel) {
        this.adTel = adTel;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalHc() {
        return totalHc;
    }

    public void setTotalHc(int totalHc) {
        this.totalHc = totalHc;
    }

    public int getCurrHc() {
        return currHc;
    }

    public void setCurrHc(int currHc) {
        this.currHc = currHc;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }


}
