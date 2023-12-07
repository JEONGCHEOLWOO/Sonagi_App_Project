package com.sona.gi.model.abilityDonation.mapper;

import com.sona.gi.model.abilityDonation.dto.AbilityDonationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AbilityDonationMapper {
    int regist(AbilityDonationDto abilityDonationDto);
    List<AbilityDonationDto> findAll();
    int delete(AbilityDonationDto abilityDonationDto);
    List<AbilityDonationDto> findByadName(AbilityDonationDto abilityDonationDto);
}
