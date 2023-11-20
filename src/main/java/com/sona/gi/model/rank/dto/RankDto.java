package com.sona.gi.model.rank.dto;

public class RankDto {

    //랭킹 순위
    private String ranking;

    //가게 이름
    private String adName;

    //기부 횟수
    private String donateCount;

    //기부한 금액
    private String donatePrice;

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getDonateCount() {
        return donateCount;
    }

    public void setDonateCount(String donateCount) {
        this.donateCount = donateCount;
    }

    public String getDonatePrice() {
        return donatePrice;
    }

    public void setDonatePrice(String donatePrice) {
        this.donatePrice = donatePrice;
    }
}
