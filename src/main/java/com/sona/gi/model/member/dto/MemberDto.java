package com.sona.gi.model.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    //보육원 DTO

    private String id; //primary key
    private String password;
    //보육원 이름
    private String adName;
    //시설 전화번호
    private String adTel;
    //시설장 이름
    private String managerName; //primary key?
    //개인 전화번호
    private String phoneNum;

    private String address;
    private String homepage;

    //총 인원수 (HC : head count)
    private int totalHC;

    //현재 인원수
    private int currHC;


}
