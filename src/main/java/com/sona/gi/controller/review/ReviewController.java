package com.sona.gi.controller.review;

import com.sona.gi.model.review.dto.ReviewDto;
import com.sona.gi.service.review.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/review")
public class ReviewController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ReviewService reviewService;


    @PostMapping("/regist")
    public HashMap<String, Object> regist(@RequestBody ReviewDto reviewDto){
        HashMap<String,Object> mv = new HashMap<>();

        int resultCnt = reviewService.regist(reviewDto);
        mv.put("result",resultCnt);
        return mv;
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public HashMap<String,Object> findAll(){
        HashMap<String,Object> mv = new HashMap<>();
        List<ReviewDto> list = reviewService.findAll();
        mv.put("list",list);
        return mv;
    }

    //검색 get, 수정 삭제 post
    @PostMapping("/modify")
    public HashMap<String,Object> modify(@RequestBody ReviewDto reviewDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= reviewService.modify(reviewDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody ReviewDto reviewDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= reviewService.delete(reviewDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }
}
