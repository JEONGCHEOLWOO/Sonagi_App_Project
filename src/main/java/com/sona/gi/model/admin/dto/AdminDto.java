package com.sona.gi.model.admin.dto;

public class AdminDto {
    private String id; //primary key
    //시설 이름
    private String adName;
    //시설 전화번호
    private String adTel;
    //시설장 이름
    private String managerName;

    private String address;

    private String introduction;

    private int totalHc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getTotalHc() {
        return totalHc;
    }

    public void setTotalHc(int totalHc) {
        this.totalHc = totalHc;
    }
}
