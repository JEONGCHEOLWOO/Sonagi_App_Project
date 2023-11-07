package com.sona.gi.service.donation;

import com.sona.gi.model.donation.dto.DonationDto;
import com.sona.gi.model.donation.mapper.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService{

    @Autowired
    private DonationMapper donationMapper;

    @Override
    public int regist(DonationDto donationDto) {
        return donationMapper.regist(donationDto);
    }

    @Override
    public List<DonationDto> findAll() {
        return donationMapper.findAll();
    }

    @Override
    public int modify(DonationDto donationDto) {
        return donationMapper.modify(donationDto);
    }

    @Override
    public int delete(DonationDto donationDto) {
        return donationMapper.delete(donationDto);
    }
}
