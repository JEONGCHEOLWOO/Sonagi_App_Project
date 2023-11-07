package com.sona.gi.model.rank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RankDto {

    //랭킹 순위
    private String ranking;

    //가게 이름
    private String adName;

    //기부 횟수
    private String donateCount;

    //기부한 금액
    private String donatePrice;
}
