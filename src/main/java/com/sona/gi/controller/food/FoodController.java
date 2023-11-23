package com.sona.gi.controller.food;

import com.sona.gi.model.food.dto.FoodDto;
import com.sona.gi.service.food.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/food")
public class FoodController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private FoodService foodService;


    @PostMapping("/regist")
    public int regist(@RequestBody FoodDto foodDto){
        int resultCnt = foodService.regist(foodDto);
        return resultCnt;
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public HashMap<String,Object> findAll(){
        HashMap<String,Object> mv = new HashMap<>();
        List<FoodDto> list = foodService.findAll();
        mv.put("list",list);
        return mv;
    }



    //검색 get, 수정 삭제 post
    @PostMapping("/modify")
    public HashMap<String,Object> modify(@RequestBody FoodDto foodDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= foodService.modify(foodDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody FoodDto foodDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= foodService.delete(foodDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }
}
