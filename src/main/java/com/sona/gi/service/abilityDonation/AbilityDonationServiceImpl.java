package com.sona.gi.service.abilityDonation;

import com.sona.gi.model.abilityDonation.dto.AbilityDonationDto;
import com.sona.gi.model.abilityDonation.mapper.AbilityDonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityDonationServiceImpl implements AbilityDonationService{
    @Autowired
    private AbilityDonationMapper abilityDonationMapper;

    @Override
    public int regist(AbilityDonationDto abilityDonationDto) { return abilityDonationMapper.regist(abilityDonationDto);}

    @Override
    public List<AbilityDonationDto> findAll() { return abilityDonationMapper.findAll();}

    @Override
    public int delete(AbilityDonationDto abilityDonationDto) { return abilityDonationMapper.delete(abilityDonationDto); }

    @Override
    public List<AbilityDonationDto> findByadName(AbilityDonationDto abilityDonationDto) { return abilityDonationMapper.findByadName(abilityDonationDto); }

}
