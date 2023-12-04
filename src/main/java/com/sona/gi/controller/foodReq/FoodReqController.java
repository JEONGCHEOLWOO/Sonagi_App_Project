package com.sona.gi.controller.foodReq;

import com.sona.gi.model.foodReq.dto.FoodReqDto;
import com.sona.gi.service.foodReq.FoodReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/boot/foodReq")
public class FoodReqController {
    @Autowired
    private FoodReqService foodReqService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/regist")
    public int regist(@RequestBody FoodReqDto foodReqDto){
        int resultCnt = foodReqService.regist(foodReqDto);
        return resultCnt;
    }

    @PostMapping("/findById")
    public List<FoodReqDto> findById(@RequestBody FoodReqDto foodReqDto){
        List<FoodReqDto> list = foodReqService.findById(foodReqDto);
        return list;
    }

    @PostMapping("/findByIdFoodNameSenderId")
    public int findByIdFoodNameSenderId(@RequestBody FoodReqDto foodReqDto){
        int resultCnt = foodReqService.findByIdFoodNameSenderId(foodReqDto);
        return resultCnt;
    }

    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody FoodReqDto foodReqDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= foodReqService.delete(foodReqDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/findBySenderId")
    public List<FoodReqDto> findBySenderId(@RequestBody FoodReqDto foodReqDto){
        List<FoodReqDto> list = foodReqService.findBySenderId(foodReqDto);
        return list;
    }

    @PostMapping("/senderDelete")
    public int senderDelete(@RequestBody FoodReqDto foodReqDto){
        int resultCnt= foodReqService.senderDelete(foodReqDto);
        return resultCnt;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void truncateTable() {
        jdbcTemplate.execute("TRUNCATE TABLE DonationRequest");
    }

}
