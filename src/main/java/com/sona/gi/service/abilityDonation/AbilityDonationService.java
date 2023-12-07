package com.sona.gi.service.abilityDonation;

import com.sona.gi.model.abilityDonation.dto.AbilityDonationDto;

import java.util.List;

public interface AbilityDonationService {
    int regist(AbilityDonationDto abilityDonationDto);
    List<AbilityDonationDto> findAll();
    int delete(AbilityDonationDto abilityDonationDto);
    List<AbilityDonationDto> findByadName(AbilityDonationDto abilityDonationDto);
}
