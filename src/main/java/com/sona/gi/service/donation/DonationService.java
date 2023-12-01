package com.sona.gi.service.donation;

import com.sona.gi.model.donation.dto.DonationDto;

import java.util.List;

public interface DonationService {

    int regist(DonationDto donationDto);
    List<DonationDto> findAll();
    int modify(DonationDto donationDto);
    int delete(DonationDto donationDto);
    List<DonationDto> findByIdP(DonationDto donationDto);
    List<DonationDto> findByIdR(DonationDto donationDto);
    int IsReviewed(DonationDto donationDto);
}
