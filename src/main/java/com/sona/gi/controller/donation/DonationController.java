package com.sona.gi.controller.donation;

import com.sona.gi.model.donation.dto.DonationDto;
import com.sona.gi.service.donation.DonationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/boot/donation")
public class DonationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private DonationService donationService;


    @PostMapping("/regist")
    public int regist(@RequestBody DonationDto donationDto) {
        int resultCnt = donationService.regist(donationDto);
        return resultCnt;
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public List<DonationDto> findAll() {
        List<DonationDto> list = donationService.findAll();
        return list;
    }

    //검색 get, 수정 삭제 post
    @PostMapping("/modify")
    public int modify(@RequestBody DonationDto donationDto) {
        int resultCnt = donationService.modify(donationDto);
        return resultCnt;
    }

    @PostMapping("/findByIdP")
    public List<DonationDto> findByIdP(@RequestBody DonationDto donationDto){
        List<DonationDto> list = donationService.findByIdP(donationDto);
        return list;
    }

    @PostMapping("/findByIdR")
    public List<DonationDto> findByIdR(@RequestBody DonationDto donationDto){
        List<DonationDto> list = donationService.findByIdR(donationDto);
        return list;
    }

    @PostMapping("/IsReviewed")
    public int IsReviewed (@RequestBody DonationDto donationDto){
        int resultCnt = donationService.IsReviewed(donationDto);
        return resultCnt;
    }
}
