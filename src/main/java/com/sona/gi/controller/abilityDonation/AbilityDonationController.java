package com.sona.gi.controller.abilityDonation;

import com.sona.gi.model.abilityDonation.dto.AbilityDonationDto;
import com.sona.gi.service.abilityDonation.AbilityDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boot/Ability")
public class AbilityDonationController {

    @Autowired
    private AbilityDonationService abilityDonationService;

    @PostMapping("/regist")
    public int regist(@RequestBody AbilityDonationDto abilityDonationDto){
        int resultCnt = abilityDonationService.regist(abilityDonationDto);
        return resultCnt;
    }

    @GetMapping("/findAll")
    public List<AbilityDonationDto> findAll(){
        List<AbilityDonationDto> list = abilityDonationService.findAll();
        return list;
    }

    @PostMapping("/delete")
    public int delete(@RequestBody AbilityDonationDto abilityDonationDto){
        int resultCnt = abilityDonationService.delete(abilityDonationDto);
        return resultCnt;
    }

    @PostMapping("/findByadName")
    public List<AbilityDonationDto> findByadName(@RequestBody AbilityDonationDto abilityDonationDto){
        List<AbilityDonationDto> list = abilityDonationService.findByadName(abilityDonationDto);
        return list;
    }
}
