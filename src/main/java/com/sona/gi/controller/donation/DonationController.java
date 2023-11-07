package com.sona.gi.controller.donation;

import com.sona.gi.model.donation.dto.DonationDto;
import com.sona.gi.model.member.dto.MemberDto;
import com.sona.gi.service.donation.DonationService;
import com.sona.gi.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/donation")
public class DonationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private DonationService donationService;


    @PostMapping("/regist")
    public HashMap<String, Object> regist(@RequestBody DonationDto donationDto){
        HashMap<String,Object> mv = new HashMap<>();

        int resultCnt = donationService.regist(donationDto);
        mv.put("result",resultCnt);
        return mv;
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public HashMap<String,Object> findAll(){
        HashMap<String,Object> mv = new HashMap<>();
        List<DonationDto> list = donationService.findAll();
        mv.put("list",list);
        return mv;
    }

    //검색 get, 수정 삭제 post
    @PostMapping("/modify")
    public HashMap<String,Object> modify(@RequestBody DonationDto donationDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= donationService.modify(donationDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody DonationDto donationDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= donationService.delete(donationDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }
}
