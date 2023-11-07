package com.sona.gi.controller.rank;

import com.sona.gi.model.member.dto.MemberDto;
import com.sona.gi.model.rank.dto.RankDto;
import com.sona.gi.service.member.MemberService;
import com.sona.gi.service.rank.RankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/rank")
public class RankController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private RankService rankService;


    @PostMapping("/regist")
    public HashMap<String, Object> regist(@RequestBody RankDto rankDto){
        HashMap<String,Object> mv = new HashMap<>();

        int resultCnt = rankService.regist(rankDto);
        mv.put("result",resultCnt);
        return mv;
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public HashMap<String,Object> findAll(){
        HashMap<String,Object> mv = new HashMap<>();
        List<RankDto> list = rankService.findAll();
        mv.put("list",list);
        return mv;
    }

    //검색 get, 수정 삭제 post
    @PostMapping("/modify")
    public HashMap<String,Object> modify(@RequestBody RankDto rankDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= rankService.modify(rankDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody RankDto rankDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= rankService.delete(rankDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }
}
