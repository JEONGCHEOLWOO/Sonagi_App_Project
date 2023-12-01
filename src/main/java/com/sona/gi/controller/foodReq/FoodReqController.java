package com.sona.gi.controller.foodReq;

import com.sona.gi.model.foodReq.dto.FoodReqDto;
import com.sona.gi.service.foodReq.FoodReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/boot/foodReq")
public class FoodReqController {
    @Autowired
    private FoodReqService foodReqService;

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

    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody FoodReqDto foodReqDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= foodReqService.delete(foodReqDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }



}
