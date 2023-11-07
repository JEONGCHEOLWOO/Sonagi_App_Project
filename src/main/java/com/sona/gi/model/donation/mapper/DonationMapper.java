package com.sona.gi.model.donation.mapper;

import com.sona.gi.model.donation.dto.DonationDto;
import com.sona.gi.model.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonationMapper {

    int regist(DonationDto donationDto);
    List<DonationDto> findAll();
    int modify(DonationDto donationDto);

    int delete(DonationDto donationDto);
}
