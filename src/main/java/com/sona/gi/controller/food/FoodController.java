package com.sona.gi.controller.food;

import com.sona.gi.model.food.dto.FoodDto;
import com.sona.gi.model.member.dto.MemberDto;
import com.sona.gi.service.firebase.FireBaseService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.sona.gi.service.food.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/food")
@Component
public class FoodController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private FoodService foodService;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private FireBaseService fireBaseService;

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

    @PostMapping("/findById")
    public List<FoodDto> findById(@RequestBody FoodDto foodDto){
        List<FoodDto> list = foodService.findById(foodDto);
        return list;
    }

    @PostMapping("/files")
    public String uploadFileToFirebase(
            @RequestParam("file") MultipartFile file,
            @RequestParam("nameFile") String nameFile,
            @RequestParam("folderName") String folderName
    ) {
        try {
            String imageUrl = fireBaseService.uploadFiles(file, nameFile, folderName);
            return imageUrl;
        } catch (Exception e) {
            return nameFile;
        }
    }

    @PostMapping("/updateImageUrl") // id, foodImage 필요!
    public int updateImageUrl(@RequestBody FoodDto foodDto){
        int resultCnt = foodService.updateImageUrl(foodDto);
        return resultCnt;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void truncateTable() {
        jdbcTemplate.execute("TRUNCATE TABLE Food");
    }

}
